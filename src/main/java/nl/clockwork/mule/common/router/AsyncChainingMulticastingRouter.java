/*
 * $Id: ChainingMulticastingRouter.java 13138 2008-10-27 07:36:57Z rossmason $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package nl.clockwork.mule.common.router;

import org.mule.DefaultMuleMessage;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.MuleSession;
import org.mule.api.config.MuleProperties;
import org.mule.api.endpoint.OutboundEndpoint;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.routing.CouldNotRouteOutboundMessageException;
import org.mule.api.routing.RoutePathNotFoundException;
import org.mule.api.routing.RoutingException;
import org.mule.config.i18n.CoreMessages;
import org.mule.routing.outbound.ChainingRouter;
import org.mule.transport.NullPayload;

/**
 * <code>ChainingMulticastingRouter</code> is used to pass a Mule event through multiple
 * endpoints using the same input for all endpoints. If an exception is encountered the
 * router will not process any more endpoints, but will call the exception endpoint
 * instead.
 */

public class AsyncChainingMulticastingRouter extends ChainingRouter
{
	private String exceptionEndpointName;


    @Override
    public void initialise() throws InitialisationException
    {
        super.initialise();
        if (endpoints == null || endpoints.size() == 0)
        {
            throw new InitialisationException(CoreMessages.objectIsNull("endpoints"), this);
        }

//        for (int i = 0; i < endpoints.size() - 1; i++)
//        {   endpoints.get(i);
//
//        }

    }

    public MuleMessage route(MuleMessage message, MuleSession session)
        throws RoutingException
    {
        MuleMessage resultToReturn = null;
        if (endpoints == null || endpoints.size() == 0)
        {
            throw new RoutePathNotFoundException(CoreMessages.noEndpointsForRouter(), message, null);
        }

        final int endpointsCount = endpoints.size();
        if (logger.isDebugEnabled())
        {
            logger.debug("About to chain " + endpointsCount + " endpoints.");
        }

        // need that ref for an error message
        OutboundEndpoint endpoint = null;
        try
        {
//patchX
//            MuleMessage intermediaryResult = message;
        		MuleMessage intermediaryResult = new DefaultMuleMessage(message.getPayload(), message);

            for (int i = 0; i < endpointsCount; i++)
            {
                endpoint = getEndpoint(i, intermediaryResult);
                // if it's not the last endpoint in the chain,
                // enforce the synchronous call, otherwise we lose response
                boolean lastEndpointInChain = (i == endpointsCount - 1);

                if (logger.isDebugEnabled())
                {
                    logger.debug("Sending Chained message '" + i + "': "
                                 + (intermediaryResult == null ? "null" : intermediaryResult.toString()));
                }

                // All endpoints registered on a chaining router need to use RemoteSync enabled. Setting this property now. MULE-3643
                intermediaryResult.setProperty(MuleProperties.MULE_REMOTE_SYNC_PROPERTY, true);
                
                if (!lastEndpointInChain)
                {
                    MuleMessage localResult = send(session, intermediaryResult, endpoint);
                    // Need to propagate correlation info and replyTo, because there
                    // is no guarantee that an external system will preserve headers
                    // (in fact most will not)
                    if (localResult != null &&
                        // null result can be wrapped in a NullPayload
                        localResult.getPayload() != NullPayload.getInstance() &&
                        intermediaryResult != null)
                    {
                        processIntermediaryResult(localResult, intermediaryResult);
                    }
                    intermediaryResult = localResult;

                    if (logger.isDebugEnabled())
                    {
                        logger.debug("Received Chain result '" + i + "': "
                                     + (intermediaryResult != null ? intermediaryResult.toString() : "null"));
                    }
//patch
//                    if (intermediaryResult == null || intermediaryResult.getPayload() == NullPayload.getInstance())
                    if (intermediaryResult.getExceptionPayload() != null)
                    {
                        // if there was an error in the first link of the chain, make sure we propagate back
                        // any exception payloads alongside the NullPayload
//patch: return async on exception
//                        resultToReturn = intermediaryResult;
//                        logger.warn("Chaining router cannot process any further endpoints. "
//                                    + "There was no result returned from endpoint invocation: " + endpoint);
                      	resultToReturn = null;
                      	logger.warn("Sending intermediary result on to exceptionEndpointName: " + exceptionEndpointName);
                      	dispatch(session,new DefaultMuleMessage(message.getPayload(), message),muleContext.getRegistry().lookupEndpointFactory().getOutboundEndpoint(exceptionEndpointName));
                      	//FIXME??? dispatch(session,intermediaryResult,(OutboundEndpoint)new MuleEndpointURI("exceptionEndpointUri"));
                        break;
                    }
//patchX
              		intermediaryResult = new DefaultMuleMessage(message.getPayload(), message);
                }
                else
                {
                    // ok, the last call,
                    // use the 'sync/async' method parameter
                    if (endpoint.isSynchronous())
                    {
                        resultToReturn = send(session, intermediaryResult, endpoint);
                        if (logger.isDebugEnabled())
                        {
                            logger.debug("Received final Chain result '" + i + "': "
                                         + (resultToReturn == null ? "null" : resultToReturn.toString()));
                        }
                    }
                    else
                    {
                        // reset the previous call result to avoid confusion
                        resultToReturn = null;
                        dispatch(session, intermediaryResult, endpoint);
                    }
                }
            }

        }
        catch (MuleException e)
        {
            throw new CouldNotRouteOutboundMessageException(message, endpoint, e);
        }
        return resultToReturn;
    }

  	public void setExceptionEndpointName(String exceptionEndpointName)
  	{
  		this.exceptionEndpointName = exceptionEndpointName;
  	}
}


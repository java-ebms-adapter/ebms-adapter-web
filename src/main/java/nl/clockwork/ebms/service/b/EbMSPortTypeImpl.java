/*******************************************************************************
 * Copyright 2011 Clockwork
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package nl.clockwork.ebms.service.b;

import nl.clockwork.ebms.AttachmentManager;
import nl.clockwork.ebms.model.EbMSAcknowledgment;
import nl.clockwork.ebms.model.EbMSBaseMessage;
import nl.clockwork.ebms.model.EbMSMessage;
import nl.clockwork.ebms.model.EbMSMessageError;
import nl.clockwork.ebms.model.EbMSPing;
import nl.clockwork.ebms.model.EbMSStatusRequest;
import nl.clockwork.ebms.model.ebxml.AckRequested;
import nl.clockwork.ebms.model.ebxml.Acknowledgment;
import nl.clockwork.ebms.model.ebxml.ErrorList;
import nl.clockwork.ebms.model.ebxml.Manifest;
import nl.clockwork.ebms.model.ebxml.MessageHeader;
import nl.clockwork.ebms.model.ebxml.MessageOrder;
import nl.clockwork.ebms.model.ebxml.StatusRequest;
import nl.clockwork.ebms.model.ebxml.StatusResponse;
import nl.clockwork.ebms.model.ebxml.SyncReply;
import nl.clockwork.ebms.processor.EbMSMessageProcessor;
import nl.clockwork.mule.ebms.cxf.MessageManager;
import nl.clockwork.mule.ebms.cxf.SignatureManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EbMSPortTypeImpl implements EbMSPortType
{
  protected transient Log logger = LogFactory.getLog(getClass());
  private EbMSMessageProcessor messageProcessor;

	@Override
	public void messageRequest(MessageHeader messageHeader, SyncReply syncReply, MessageOrder messageOrder, AckRequested ackRequested, Manifest manifest)
	{
		messageProcessor.process(new EbMSMessage(MessageManager.get(),SignatureManager.get() == null ? null : SignatureManager.get(),messageHeader,syncReply,messageOrder,ackRequested,manifest,AttachmentManager.get()));
	}

	@Override
	public void messageResponse(MessageHeader messageHeader, SyncReply syncReply, ErrorList errorList, Acknowledgment acknowledgment)
	{
		messageProcessor.process(new EbMSMessageError(messageHeader,errorList));
		messageProcessor.process(new EbMSAcknowledgment(messageHeader,acknowledgment));
		EbMSBaseMessage result = messageProcessor.process(new EbMSPing(messageHeader,syncReply));
		//EbMSBaseMessage result = messageProcessor.process(new EbMSPong(messageHeader));
	}

	@Override
	public void statusRequest(MessageHeader messageHeader, SyncReply syncReply, StatusRequest statusRequest)
	{
		EbMSBaseMessage response = messageProcessor.process(new EbMSStatusRequest(messageHeader,syncReply,statusRequest));
	}

	@Override
	public void statusResponse(MessageHeader messageHeader, StatusResponse statusResponse)
	{
		//EbMSBaseMessage response = messageProcessor.process(new EbMSStatusResponse(messageHeader,statusResponse));
	}

	public void setMessageProcessor(EbMSMessageProcessor messageProcessor)
	{
		this.messageProcessor = messageProcessor;
	}
	
}
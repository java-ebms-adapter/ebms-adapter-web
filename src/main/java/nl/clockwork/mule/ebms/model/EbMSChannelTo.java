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
package nl.clockwork.mule.ebms.model;

import java.util.List;

import nl.clockwork.mule.ebms.model.ebxml.PartyId;
import nl.clockwork.mule.ebms.model.ebxml.To;

public class EbMSChannelTo extends To
{
  public void setPartyId(List<PartyId> partyId)
	{
		this.partyId = partyId;
	}
}

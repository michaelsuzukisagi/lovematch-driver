/*
 * Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 * This file is part of Alfresco
 *
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 */
package org.alfresco.bm.process;

import java.util.Collections;

import org.alfresco.bm.event.Event;
import org.alfresco.bm.event.EventResult;
import org.alfresco.bm.http.AuthenticatedHttpEventProcessor;
import org.alfresco.http.AuthenticationDetailsProvider;
import org.alfresco.http.HttpClientProvider;
import org.alfresco.http.SimpleHttpRequestCallback;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

/**
 * Event processor that calls the love match api.
 * 
 * <h1>Actions</h1><br/>
 * Http get to the love match api,which registers success when a page response
 * is 200 ok.
 * <p/>
 * <h1>Output</h1>
 * No next event will be scheduled.
 * 
 * @author Michael Suzuki
 * @since 1.1
 */
public class GetLoveMatch extends AuthenticatedHttpEventProcessor
{
    /**
     * URL for love match api.
     */
    private static final String LOVE_MATCH_URL = "/alfresco/service/sample/lovematch";
    private static final String EVENT_NAME_LOVE_MATCH_DONE = "getLoveMatchDone";
    private String eventNameProcessDone; 
    /**
     * Constructor
     * @param httpClientProvider
     * @param authDetailProvider
     * @param baseUrl
     */
    public GetLoveMatch(HttpClientProvider httpClientProvider,
                        AuthenticationDetailsProvider authDetailProvider,
                        String baseUrl,
                        long numberOfCalls)
    {
        super(httpClientProvider, authDetailProvider, baseUrl);
        this.eventNameProcessDone = EVENT_NAME_LOVE_MATCH_DONE; 
    }
    
    public void setEventNameProcessDone(String eventNameProcessDone)
    {
        this.eventNameProcessDone = eventNameProcessDone;
    }

    @Override
    protected EventResult processEvent(Event event) throws Exception 
    {
        //Suspend time.
        super.suspendTimer();
        EventResult eventResult = null;
        String url = getFullUrlForPath(LOVE_MATCH_URL);
        HttpGet getLoveMatch = new HttpGet(url);
        //Start recording time of response
        super.resumeTimer();
        // Get the status
        HttpResponse httpResponse = executeHttpMethodAsAdmin(
                getLoveMatch,
                SimpleHttpRequestCallback.getInstance());
        StatusLine httpStatus = httpResponse.getStatusLine();
        // Pause timer
        super.suspendTimer();
        // Expecting "OK" status
        if (httpStatus.getStatusCode() != HttpStatus.SC_OK)
        {
         // User creation failed
            String msg = String.format(
                    "Love match failed, REST-call resulted in status:%d with error %s ",
                    httpStatus.getStatusCode(),
                    httpStatus.getReasonPhrase());
            eventResult = new EventResult(msg, false);
        }
        else
        {
            // Event execution was successful
            Event doneEvent = new Event(eventNameProcessDone, 0L, null);
            eventResult = new EventResult("Love match invokation completed.", doneEvent);

            eventResult = new EventResult("Love match response successful", Collections.<Event> emptyList());
            // User should be usable
        }
        return eventResult;
    }

}

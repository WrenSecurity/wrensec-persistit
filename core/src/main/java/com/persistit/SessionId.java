/**
 * Copyright (C) 2011 Akiban Technologies Inc.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses.
 */

package com.persistit;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Identity key for a session. Normally there is one session per thread, but
 * applications that need to maintain session context across multiple network
 * requests serviced on different threads can access and carefully modify their
 * session contexts using SessionID. See {@link Persistit#getSessionId()} and
 * {@link Persistit#setSessionId(SessionId)}.
 * 
 * @author peter
 * 
 */
public class SessionId {

    private final static AtomicInteger counter = new AtomicInteger(1);

    private final int _id = counter.getAndIncrement();

    @Override
    public boolean equals(final Object id) {
        if (id == null || !(id instanceof SessionId)) {
            return false;
        }
        return this._id == ((SessionId) id)._id;
    }

    @Override
    public int hashCode() {
        return _id;
    }

    @Override
    public String toString() {
        return "[" + _id + "]";
    }
}

package org.aksw.gerbil.semantic;

import java.util.Set;

public interface SameAsRetriever {

    /**
     * Returns a Set containing the URIs having a sameAs link to this URI or
     * null if no such URIs could be found.
     * 
     * @param uri
     * @return
     */
    public Set<String> retrieveSameURIs(String uri);
}
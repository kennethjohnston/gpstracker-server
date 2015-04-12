package com.gpstracker.server.model.internal.result;

public class UserLoginProcessingResult extends AbstractProcessingResult {

    private static final long serialVersionUID = 1L;
    private String authenicationToken;

    /**
     * @return the authenicationToken
     */
    public String getAuthenicationToken() {
        return authenicationToken;
    }

    /**
     * @param authenicationToken the authenicationToken to set
     */
    public void setAuthenicationToken(String authenicationToken) {
        this.authenicationToken = authenicationToken;
    }    
}

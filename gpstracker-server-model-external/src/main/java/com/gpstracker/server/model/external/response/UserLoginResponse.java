package com.gpstracker.server.model.external.response;


public class UserLoginResponse extends RawUserResponse {

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

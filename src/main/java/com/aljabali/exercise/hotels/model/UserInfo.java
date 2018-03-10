
package com.aljabali.exercise.hotels.model;


public class UserInfo {

    private Persona persona;
    private String userId;

    public Persona getPersona() {
        return persona;
    }

    public UserInfo setPersona(Persona persona) {
        this.persona = persona;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public UserInfo setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}

package com.akdenizbank.mls.xaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAdminUserXAction {

    protected String name;

    protected String surname;

    protected String email;

    protected String password;
}

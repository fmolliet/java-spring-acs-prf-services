package io.winty.sec.acsprfservices.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class AccessProfileTransactionId implements Serializable {
    private String accessProfile;
    private String transaction;
}
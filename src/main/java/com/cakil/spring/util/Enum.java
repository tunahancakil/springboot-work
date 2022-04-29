package com.cakil.spring.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Enum {
    public enum ApplicationStatus {

        APPROVE("APPROVE", "Your application has been approved."),
        REJECTED("REJECTED", "Your application has been rejected.");

        private String value;
        private String message;

        ApplicationStatus(String value, String message) {
            this.value = value;
            this.message = message;
        }

        public String getValue() {
            return value;
        }

        public String getMessage() {
            return message;
        }

        public static ApplicationStatus fromValue(String value) {
            for (ApplicationStatus applicationStatus : values()) {
                if (applicationStatus.getValue().equalsIgnoreCase(value)) {
                    return applicationStatus;
                }
            }
            return null;
        }
    }
}

package Farah_Bushra_2520877.TelecomOperatorRepresentive;
import java.io.Serializable;

    public class TelecomOperatorRepresentive implements Serializable {

        private final String operatorId;
        private String name;
        private String companyName;
        private String registrationNumber;

        public TelecomOperatorRepresentive(String operatorId,
                                           String name,
                                           String companyName,
                                           String registrationNumber) {
            this.operatorId = operatorId;
            this.name = name;
            this.companyName = companyName;
            this.registrationNumber = registrationNumber;
        }

        public String getOperatorId() {
            return operatorId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getRegistrationNumber() {
            return registrationNumber;
        }

        public void setRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
        }

        @Override
        public String toString() {
            return "TelecomOperatorRepresentive{" +
                    "operatorId='" + operatorId + '\'' +
                    ", name='" + name + '\'' +
                    ", companyName='" + companyName + '\'' +
                    ", registrationNumber='" + registrationNumber + '\'' +
                    '}';
        }
    }


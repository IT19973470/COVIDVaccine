package lk.vaccine.dto;

import lk.vaccine.entity.VaccineUser;

public class VaccineUserDTO {

    private String userNic;
    private String username;
    private String password;
    private String type;

    public VaccineUserDTO(VaccineUser vaccineUser) {
        if (vaccineUser != null) {
            this.userNic = vaccineUser.getUserNic();
            this.username = vaccineUser.getUsername();
            this.password = vaccineUser.getPassword();
            this.type = vaccineUser.getType();
        }
    }

    public String getUserNic() {
        return userNic;
    }

    public void setUserNic(String userNic) {
        this.userNic = userNic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

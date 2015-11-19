package app.IMAS.Entities;

import org.hibernate.validator.constraints.NotEmpty;
import app.IMAS.CustomValidators.FieldMatch;



@FieldMatch.List({
    @FieldMatch(first = "newPassword", second = "confirmNewPassword")
})
public class ChangePassword {
	@NotEmpty(message="Enter Old Password")
	String oldPassword;
	@NotEmpty(message="Enter New Password")
	String newPassword;
	
	@NotEmpty(message="Enter Again Your New Password")
	String confirmNewPassword;	

	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}
	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
	
}

package user.bean;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserImageDTO {
	private String seq;
	private String imageName;
	private String imageContent;
	private String image1; // uploadForm의 input 값과 name 이 다르다 .
}

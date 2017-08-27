package design_pattern.dynamic_proxy;

public class PersonBeanImpl implements PersonBean {
	String name;
	String gender;
	String interets;
	int rating;
	int ratingCount = 0;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public String getInterests() {
		return interets;
	}

	@Override
	public int getHotOrNotRating() {
		return (rating / ratingCount);
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public void setInterests(String interests) {
		this.interets = interests;
	}

	@Override
	public void setHotOrNotRating(int rating) {
		this.rating += rating;
		ratingCount++;
	}

}

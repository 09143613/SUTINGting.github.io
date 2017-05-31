package model;
public class GuitarSpec {
 
	  private Builder builder; 
	  private String model;
	  private Type type;
	  private Wood backWood;
	  private Wood topWood; 
	  private int numStrings;

	  public GuitarSpec(Builder builder, String model, Type type,
	                   Wood backWood, Wood topWood,int numStrings) {
	    this.builder = builder;
	    this.model = model;
	    this.type = type;
	    this.backWood = backWood;
	    this.topWood = topWood;
	    this.numStrings=numStrings;
	  }

	  public Builder getBuilder() {
	    return builder;
	  }

	  public String getModel() {
	    return model;
	  }

	  public Type getType() {
	    return type;
	  }


	  public Wood getBackWood() {
	    return backWood;
	  }

	  public Wood getTopWood() {
	    return topWood;
	  }
	  
	  public int getNumStrings() {
		return numStrings;
	}

		public void setNumStrings(int numStrings) {
			this.numStrings = numStrings;
		}

	public boolean matches(GuitarSpec otherSpec) {
	    if ((otherSpec.builder!=null) && (!otherSpec.builder.equals("")) &&builder != otherSpec.builder)
	      return false;
	    if ((otherSpec.model!=null) && (!otherSpec.model.equals(""))&&(model != null) && (!model.equals("")) &&
	        (!model.toLowerCase().equals(otherSpec.model.toLowerCase())))
	      return false;
	    if ((otherSpec.type != null) &&(!otherSpec.type.equals("")) &&type != otherSpec.type)
	      return false;
	    if ((otherSpec.backWood != null) &&(!otherSpec.backWood.equals("")) &&backWood != otherSpec.backWood)
	      return false;
	    if (( otherSpec.topWood != null) &&(! otherSpec.topWood.equals("")) &&topWood != otherSpec.topWood)
	      return false;
	    return true;
	  }
	
	public void setBuider(Builder builder) {
		// TODO Auto-generated method stub
		this.builder=builder;
	}

	public void setModel(String model) {
		// TODO Auto-generated method stub
		this.model=model;
	}

	public void setType(Type type) {
		// TODO Auto-generated method stub
		this.type=type;
	}

	public void setBackWood(Wood backWood) {
		// TODO Auto-generated method stub
		this.backWood=backWood;
	}

	public void setTopWood(Wood topWood) {
		// TODO Auto-generated method stub
		this.topWood=topWood;
	}
}

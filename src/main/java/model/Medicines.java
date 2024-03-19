package model;


public class  Medicines {
	private String name;
	private String type;
	
	public Medicines (String name, String type, String timing) {
		this.name = name;
		this.type = type;
	}
		
		public String getName() {
			return name;
		}
		
		public String getType () {
			return type;
		}
		
		 public void setName(String name) {
		        this.name = name;
		    }
		 
		 public void setType(String type) {
		        this.type = type;
		    }

		public String getTiming() {
			// TODO 自動生成されたメソッド・スタブ
			return timing;
		}

		public int getMedicines_id() {
			// TODO 自動生成されたメソッド・スタブ
			return medicines_id;
		}
	
}
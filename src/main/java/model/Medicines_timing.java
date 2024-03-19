package model;


public class  Medicines_timing {
	private int medicines_id;
	private String timing;
	
	public Medicines_timing (int medicines_id, String timing) {
		this.medicines_id = medicines_id;
		this.timing = timing;
	}
		
		public int getMedicines_id() {
			return medicines_id;
		}
		
		public String getTiming () {
			return timing;
		}
		
		 public void setMedicines_id(int medicines_id) {
		        this.medicines_id = medicines_id;
		    }
	
		 public void setTiming(String timing) {
		        this.timing = timing;
		    }
}
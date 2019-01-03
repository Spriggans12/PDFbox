package fr.spriggans.pdfbox.model;

public class Choice {
	
	public static final int NOTHING = 0;
	public static final int AJOUT = 1;
	public static final int SUPPR = 2;

	private int id;
	
	private String label;

	public Choice(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}

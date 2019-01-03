package fr.spriggans.pdfbox.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import fr.spriggans.pdfbox.model.Choice;

public class PdfBoxAction extends ActionSupport {

	private static final long serialVersionUID = 8522359609292682753L;
	
	private static final String MIME_PDF = "application/pdf";

	private List<String> errors = new ArrayList<>();

	private List<Choice> choices;
	private int choosedChoice;

	private File originalPdfFile;
	private String originalPdfFilecontentType;
	private String originalPdfFileFilename;

	private File fileToAddPdfFile;
	private String fileToAddcontentType;
	private String fileToAddFilename;

	public String uploadAction() {
		System.out.println("-------");
		System.out.println(originalPdfFilecontentType);
		System.out.println(originalPdfFileFilename);

		System.out.println(fileToAddcontentType);
		System.out.println(fileToAddFilename);

		System.out.println(choosedChoice);
		System.out.println("-------");
		
		if (!validateForm()) {
			return "SUCCESS";
		}

		if(Choice.AJOUT == this.choosedChoice) {
			
		}

		return "SUCCESS";
	}

	private boolean validateForm() {
		boolean res = true;
		if (Choice.NOTHING == this.choosedChoice) {
			errors.add("Vous devez choisir une action.");
			res = false;
		}
		if (this.originalPdfFile == null) {
			errors.add("Vous devez renseigner le PDF d'origine.");
			res = false;
		} else {
			if(!MIME_PDF.equals(this.originalPdfFilecontentType)) {
				errors.add("Le fichier d'origine n'est pas au bon format.");
				res = false;
			}
		}
		// AJOUT
		if (Choice.AJOUT == this.choosedChoice) {
			
			if (this.fileToAddPdfFile == null) {
				errors.add("Vous devez renseigner le PDF à ajouter.");
				res = false;
			} else {
				if(!MIME_PDF.equals(this.fileToAddcontentType)) {
					errors.add("Le fichier à ajouter n'est pas au bon format.");
					res = false;
				}
			}
			
		}

		// SUPPRESSION
		if (Choice.SUPPR == this.choosedChoice) {

		}

		return res;
	}

	public String init() {
		return "SUCCESS";
	}

	public void setOriginalPdfFile(File originalPdfFile) {
		this.originalPdfFile = originalPdfFile;
	}

	public void setOriginalPdfFileContentType(String contentType) {
		this.originalPdfFilecontentType = contentType;
	}

	public void setOriginalPdfFileFileName(String filename) {
		this.originalPdfFileFilename = filename;
	}

	public void setFileToAddPdfFile(File fileToAddPdfFile) {
		this.fileToAddPdfFile = fileToAddPdfFile;
	}

	public void setFileToAddPdfFileContentType(String contentType) {
		this.fileToAddcontentType = contentType;
	}

	public void setFileToAddPdfFileFileName(String filename) {
		this.fileToAddFilename = filename;
	}

	public int getChoosedChoice() {
		return choosedChoice;
	}

	public void setChoosedChoice(int choosedChoice) {
		this.choosedChoice = choosedChoice;
	}

	public List<Choice> getChoices() {
		choices = new ArrayList<>();
		choices.add(new Choice(Choice.NOTHING, "Choisir une action"));
		choices.add(new Choice(Choice.AJOUT, "Ajouter des pages à mon PDF"));
		choices.add(new Choice(Choice.SUPPR, "Supprimer des pages de mon PDF"));
		return choices;
	}

	public List<String> getErrors() {
		return this.errors;
	}
}

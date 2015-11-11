package org.insightcentre.cosmic.yasir.cnv.script;

public class CNV {
	
	private String CNV_ID;
	private String ID_Sample;
	private String ID_Tumour;
	private String Primary_Site;
	private String Site_Subtype;
	private String Primary_Histology;
	private String Histology_Subtype;
	private String MUT_TYPE;
	private String Mutation_Genome_Position;
	private String chr_no;
	private String chrom_start;
	private String chrom_stop;
	
	
	
	
	public String getCNV_ID() {
		return CNV_ID;
	}
	public void setCNV_ID(String cNV_ID) {
		CNV_ID = cNV_ID;
	}
	public String getID_Sample() {
		return ID_Sample;
	}
	public void setID_Sample(String iD_Sample) {
		ID_Sample = iD_Sample;
	}
	public String getID_Tumour() {
		return ID_Tumour;
	}
	public void setID_Tumour(String iD_Tumour) {
		ID_Tumour = iD_Tumour;
	}
	public String getPrimary_Site() {
		return Primary_Site;
	}
	public void setPrimary_Site(String primary_Site) {
		primary_Site = primary_Site.replace("(", "");
		primary_Site = primary_Site.replace(")", "");
		Primary_Site = primary_Site;
	}
	public String getSite_Subtype() {
		return Site_Subtype;
	}
	public void setSite_Subtype(String site_Subtype) {
		Site_Subtype = site_Subtype;
	}
	public String getPrimary_Histology() {
		return Primary_Histology;
	}
	public void setPrimary_Histology(String primary_Histology) {
		primary_Histology = primary_Histology.replace("(", "");
		primary_Histology = primary_Histology.replace(")", "");
		primary_Histology = primary_Histology.replace(";", "-");
		Primary_Histology = primary_Histology;
	}
	public String getHistology_Subtype() {
		return Histology_Subtype;
	}
	public void setHistology_Subtype(String histology_Subtype) {
		histology_Subtype = histology_Subtype.replace("(", "");
		histology_Subtype = histology_Subtype.replace(")", "");
		histology_Subtype = histology_Subtype.replace(" ", "_");
		Histology_Subtype = histology_Subtype;
	}
	public String getMUT_TYPE() {
		return MUT_TYPE;
	}
	public void setMUT_TYPE(String mUT_TYPE) {
		MUT_TYPE = mUT_TYPE;
	}
	public String getMutation_Genome_Position() {
		return Mutation_Genome_Position;
	}
	public void setMutation_Genome_Position(String mutation_Genome_Position) {
		Mutation_Genome_Position = mutation_Genome_Position;
		String[] mgpArray = mutation_Genome_Position.split(":");
		if(mgpArray[0].equals("24"))
			this.setChr_no("Y");
		else if(mgpArray[0].equals("23"))
			this.setChr_no("X");
		else
			this.setChr_no(mgpArray[0]);
		String[] chrArray = mgpArray[1].split("\\.\\.");
		this.setChrom_start(chrArray[0]);
		this.setChrom_stop(chrArray[1]);
	}
	public String getChr_no() {
		return chr_no;
	}
	public void setChr_no(String chr_no) {
		this.chr_no = chr_no;
	}
	public String getChrom_start() {
		return chrom_start;
	}
	public void setChrom_start(String chrom_start) {
		this.chrom_start = chrom_start;
	}
	public String getChrom_stop() {
		return chrom_stop;
	}
	public void setChrom_stop(String chrom_stop) {
		this.chrom_stop = chrom_stop;
	}
	

}

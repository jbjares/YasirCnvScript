package org.insightcentre.cosmic.yasir.cnv.script;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import au.com.bytecode.opencsv.CSVReader;

public class CNVRDFTransformer {


	private static String basePrefix = "cs";
	private static String baseURI = "http://cosmic.sels.insight.org/schema/";
	private static String cosmicPrefix = "c";
	private static String cosmicURI = "http://cosmic.sels.insight.org/";
	private static String resultPrefix = "r";
	private static String resultURI = "http://cosmic.sels.insight.org/schema/result";
	private static String cnvResultPrefix = "t";
	private static String cnvResultURI = "http://cosmic.sels.insight.org/schema/cnv_result";
	private static String sampleIDPrefix = "i";
	private static String sampleIDURI = "http://cosmic.sels.insight.org/schema/ID_Sample";
	private static String tumourIDPrefix = "d";
	private static String tumourIDURI = "http://cosmic.sels.insight.org/schema/ID_Tumour";
	private static String primarySitePrefix = "p";
	private static String primarySiteURI = "http://cosmic.sels.insight.org/schema/Primary_Site";
	private static String siteSubtypePrefix = "e";
	private static String siteSubtypeURI = "http://cosmic.sels.insight.org/schema/Site_Subtype";
	private static String primaryHistologyPrefix = "k";
	private static String primaryHistologyURI = "http://cosmic.sels.insight.org/schema/Primary_Histology";
	private static String histologySubtypePrefix = "l";
	private static String histologySubtypeURI = "http://cosmic.sels.insight.org/schema/Histology_Subtype";
	private static String mutationTypePrefix = "m";
	private static String mutationTypeURI = "http://cosmic.sels.insight.org/schema/mut_type";
	private static String chromosomePrefix = "u";
	private static String chromosomeURI = "http://cosmic.sels.insight.org/schema/chr_no";
	private static String chromosomeStartPrefix = "x";
	private static String chromosomeStartURI = "http://cosmic.sels.insight.org/schema/chrom_start";
	private static String chromosomeStopPrefix = "y";
	private static String chromosomeStopURI = "http://cosmic.sels.insight.org/schema/chrom_stop";


	public static void main(String[] args) throws Exception {
		File file = new File("C:/devel/workspace/cosmicRDFization/YasirCnvScript/src/main/resources/CNV.tsv");
		int rowCount = 0;
		JsonArray jsonArr = new JsonArray();
		CSVReader reader = new CSVReader(new FileReader(file), '\t');

		if (file.isFile()) {
			System.out.println("Processing File " + file.getName() + " ...... ");
			String[] record;
			while ((record = reader.readNext()) != null) {

				if (rowCount == 0) {
					rowCount++;
					continue;
				}
					
					CNV cnv = new CNV();

					JsonObject jsonObject = new JsonObject();
					cnv.setCNV_ID(record[0]);
					jsonObject.addProperty("CNV_ID",cnv.getCNV_ID());

					cnv.setID_Sample(record[1]);
					jsonObject.addProperty("ID_Sample",cnv.getID_Sample());

					cnv.setID_Tumour(record[2]);
					jsonObject.addProperty("ID_Tumour", cnv.getID_Tumour());

					cnv.setPrimary_Site(record[3]);
					jsonObject.addProperty("Primary_Site",cnv.getPrimary_Site());

					cnv.setSite_Subtype(record[4]);
					jsonObject.addProperty("Site_Subtype", cnv.getSite_Subtype());

					cnv.setPrimary_Histology(record[5]);
					jsonObject.addProperty("Primary_Histology",cnv.getPrimary_Histology());

					cnv.setHistology_Subtype(record[6]);
					jsonObject.addProperty("Histology_Subtype",cnv.getHistology_Subtype());

					cnv.setMUT_TYPE(record[10]);
					jsonObject.addProperty("MUT_TYPE",cnv.getMUT_TYPE());

					cnv.setMutation_Genome_Position(record[13]);
					jsonObject.addProperty("Mutation_Genome_Position",cnv.getMutation_Genome_Position());
					jsonArr.add(jsonObject);
					//writeToFile(cnv, outputFile, fileIdentifier);

				// TODO Use the code below to create samples.
				if (rowCount == 80) {
					File jsonSampleFile = new File("C:/devel/workspace/cosmicRDFization/YasirCnvScript/src/main/resources/CNV.json");
					FileUtils.writeStringToFile(jsonSampleFile, jsonArr.toString());
					break;
				}
				rowCount++;
			}

		}
	}

	/**
	 * 
	 * @param directory
	 * @return
	 */
	public static File[] getFilesFromDirectory(String directory) {

		File folder = new File(directory);
		File[] listOfFiles = folder.listFiles();

		return listOfFiles;
	}


//	
//	public static void writeToFile(CNV cnv, String file, String fileIdentifier) throws Exception {
//
//		String prefixes = createPrefixes();
//
//		String triples = "";
//
//		String result = cosmicPrefix + ":CNV-" + cnv.getCNV_ID();
//		triples = basePrefix + ":CNV" + " " + resultPrefix + ":" + " " + result + ". ";
//		triplesCount++;
//		triples += result + " a " + cnvResultPrefix + ": ; ";
//		triplesCount++;
//		triples += " " + sampleIDPrefix + ": " + cosmicPrefix + ":" + cnv.getID_Sample() + " ; ";
//		triplesCount++;
//		triples += " " + tumourIDPrefix + ": " + cosmicPrefix + ":" + cnv.getID_Tumour() + " ; ";
//		triplesCount++;
//		triples += " " + primarySitePrefix + ": " + cosmicPrefix + ":" + cnv.getPrimary_Site() + " ; ";
//		triplesCount++;
//		triples += " " + siteSubtypePrefix + ": " + cosmicPrefix + ":" + cnv.getSite_Subtype() + " ; ";
//		triplesCount++;
//		triples += " " + primaryHistologyPrefix + ": " + cosmicPrefix + ":" + cnv.getPrimary_Histology() + " ; ";
//		triplesCount++;
//		triples += " " + histologySubtypePrefix + ": " + cosmicPrefix + ":" + cnv.getHistology_Subtype() + " ; ";
//		triplesCount++;
//		triples += " " + mutationTypePrefix + ": \"" + cnv.getMUT_TYPE() + "\" ; ";
//		triplesCount++;
//		triples += " " + chromosomePrefix + ": " + cosmicPrefix + ":" + cnv.getChr_no() + " ; ";
//		triplesCount++;
//		triples += " " + chromosomeStartPrefix + ": " + cosmicPrefix + ":" + cnv.getChrom_start() + " ; ";
//		triplesCount++;
//		triples += " " + chromosomeStopPrefix + ": " + cosmicPrefix + ":" + cnv.getChrom_stop() + " . ";
//		triplesCount++;
//
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
//		if (rowCount == 1) {
//			out.println(prefixes);
//		}
//		out.println(triples);
//
//	}

	/**
	 * 
	 * @return
	 */
	public static String createPrefixes() {

		String prefixeString = "";

		prefixeString += "@prefix " + basePrefix + ": <" + baseURI + "> . ";
		prefixeString += "@prefix " + cosmicPrefix + ": <" + cosmicURI + "> . ";
		prefixeString += "@prefix " + resultPrefix + ": <" + resultURI + "> . ";
		prefixeString += "@prefix " + cnvResultPrefix + ": <" + cnvResultURI + "> . ";
		prefixeString += "@prefix " + sampleIDPrefix + ": <" + sampleIDURI + "> . ";
		prefixeString += "@prefix " + tumourIDPrefix + ": <" + tumourIDURI + "> . ";
		prefixeString += "@prefix " + primarySitePrefix + ": <" + primarySiteURI + "> . ";
		prefixeString += "@prefix " + siteSubtypePrefix + ": <" + siteSubtypeURI + "> . ";
		prefixeString += "@prefix " + primaryHistologyPrefix + ": <" + primaryHistologyURI + "> . ";
		prefixeString += "@prefix " + histologySubtypePrefix + ": <" + histologySubtypeURI + "> . ";
		prefixeString += "@prefix " + mutationTypePrefix + ": <" + mutationTypeURI + "> . ";
		prefixeString += "@prefix " + chromosomePrefix + ": <" + chromosomeURI + "> . ";
		prefixeString += "@prefix " + chromosomeStartPrefix + ": <" + chromosomeStartURI + "> . ";
		prefixeString += "@prefix " + chromosomeStopPrefix + ": <" + chromosomeStopURI + "> . ";

		return prefixeString;
	}

	/**
	 * 
	 * @param stats
	 * @throws Exception
	 */
	public static void writeStatsToFile(String stats, String statsFile) throws Exception {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(statsFile, true)));
	}
}

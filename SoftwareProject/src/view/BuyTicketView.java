package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import controller.ActionMenuController;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyTicketView extends JPanel {
	private JTextField textField;
	private JTextField txtPrijs;
	
	/**
	 * Create the panel.
	 */
	public BuyTicketView() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		this.setLayout(sl_contentPane);
		
		JLabel lblTicketKopen = new JLabel("Ticket Kopen");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTicketKopen, 10, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTicketKopen, 20, SpringLayout.WEST, this);
		lblTicketKopen.setFont(new Font("Arial Black", Font.PLAIN, 17));
		this.add(lblTicketKopen);
		
		JLabel lblBeginstation = new JLabel("Beginstation");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBeginstation, 33, SpringLayout.SOUTH, lblTicketKopen);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBeginstation, 20, SpringLayout.WEST, this);
		add(lblBeginstation);
		
		JLabel lblEindstation = new JLabel("Eindstation");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEindstation, 16, SpringLayout.SOUTH, lblBeginstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEindstation, 0, SpringLayout.EAST, lblBeginstation);
		add(lblEindstation);
		
		JComboBox comboBox = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, -3, SpringLayout.NORTH, lblBeginstation);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, lblBeginstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox, 106, SpringLayout.EAST, lblBeginstation);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aalst", "Aalst-Kerrebroek", "Aalter", "Aarschot", "Aarsele", "Acren", "Aiseau", "Alken", "Amay", "Ampsin", "Andenne", "Angleur", "Ans", "Anseremme", "Antoing", "Antwerpen-Berchem", "Antwerpen-Centraal", "Antwerpen-Haven", "Antwerpen-Luchtbal", "Antwerpen-Noorderdokken", "Antwerpen-Oost", "Antwerpen-Zuid", "Anzegem", "Appelterre", "Archennes", "Arlon", "Asse", "Assesse", "Ath", "Athus", "Aubange", "Auvelais", "Aye", "Aywaille", "Baasrode-Zuid", "Balegem-Dorp", "Balegem-Zuid", "Balen", "Bambrugge", "Barvaux", "Bas-Oha", "Basse-Wavre", "Bastogne-Nord", "Bastogne-Sud", "Beauraing", "Beernem", "Beersel", "Beervelde", "Begijnendijk", "Beign\u00C3\u00A9e", "Bellem", "Belsele", "Sint-Agatha-Berchem/Berchem-Sainte-Agathe", "Beringen", "Berlaar", "Bertrix", "Berz\u00C3\u00A9e", "Beuzet", "Beveren", "Beverlo", "Bierges-Walibi", "Bierset-Awans", "Bilzen", "Binche", "Bissegem", "Blankenberge", "Blanmont", "Blaton", "Bleret", "Bockstael", "Boechout", "Bosvoorde/Boitsfort", "Bokrijk", "Bomal", "Booischot", "Boom", "Boondaal/Boondael", "Boortmeerbeek", "Bordet", "Bornem", "Boussu", "Bouwel", "Bracquegnies", "Braine-l'Alleud", "Braine-le-Comte", "Bressoux", "Brugelette", "Brugge", "Brugge-Sint-Pieters", "Brussel-Centraal/Bruxelles-Central", "Brussel-Congres/Bruxelles-Congr\u00C3\u00A8s", "Brussel-Kapellekerk/Bruxelles-Chapelle", "Brussel-Luxemburg/Bruxelles-Luxembourg", "Brussels Airport - Zaventem", "Brussel-Noord/Bruxelles-Nord", "Brussel-Schuman/Bruxelles-Schuman", "Brussel-West/Bruxelles-Ouest", "Brussel-Zuid/Bruxelles-Midi", "Buda", "Buggenhout", "Buizingen", "Burst", "Callenelle", "Cambron-Casteau", "Carlsbourg", "Carnieres", "Ceroux-Mousty", "Chapelle-Dieu", "Chapois", "Charleroi-Ouest", "Charleroi-Sud", "Chastre", "Ch\u00C3\u00A2teau-de-Seilles", "Ch\u00C3\u00A2telet", "Ch\u00C3\u00AAn\u00C3\u00A9e", "Ciney", "Comblain-la-Tour", "Comines", "Coo", "Couillet", "Cour-sur-Heure", "Courcelles-Motte", "Courri\u00C3\u00A8re", "Court-Saint-\u00C3\u2030tienne", "Couvin", "Dave-Saint-Martin", "De Hoek", "De Panne", "De Pinte", "Deinze", "Delta", "Denderleeuw", "Dendermonde", "Diegem", "Diepenbeek", "Diesdelle/Vivier d'Oie", "Diest", "Diksmuide", "Dilbeek", "Dinant", "Dolhain-Gileppe", "Dortmund Hbf", "Drongen", "Duffel", "Duinbergen", "\u00C3\u2030caussinnes", "Ede", "Enghien", "Eeklo", "Eichem", "Eine", "Eke-Nazareth", "Ekeren", "Engis", "Eppegem", "Erbis\u00C5\u201Cul", "Erembodegem", "Ernage", "Erpe-Mere", "Erps-Kwerps", "Erquelinnes", "Erquelinnes-Village", "Esneux", "Essen", "Essene-Lombeek", "Etterbeek", "Eupen", "Evere", "Evergem", "Ezemaal", "Familleureux", "Farciennes", "Faux", "Fexhe-le-Haut-Clocher", "Flawinne", "Flemalle-Grande", "Flemalle-Haute", "Fleurus", "Flor\u00C3\u00A9e", "Floreffe", "Florenville", "Florival", "Fontaine-Valmont", "Forchies", "Vorst-Oost/Forest-Est", "Vorst-Zuid/Forest-Midi", "Forri\u00C3\u00A8res", "Fraipont", "Frameries", "Franchimont", "Frani\u00C3\u00A8re", "Froyennes", "Galmaarden", "Gastuche", "Gavere-Asper", "Gedinne", "Geel", "Gembloux", "Gendron-Celles", "Genk", "Genly", "Gent-Dampoort", "Gent-Sint-Pieters", "Gentbrugge", "Genval", "Geraardsbergen", "Ghlin", "Glons", "Godarville", "Godinne", "Gontrode", "Gouvy", "Gouy-lez-Pieton", "Graide", "Groenendaal", "Groot-Bijgaarden", "Grupont", "Haacht", "Haaltert", "Habay", "Hainin", "Halanzy", "Halle", "Ham-sur-Heure", "Ham-sur-Sambre", "Hambos", "Hamoir", "Hamont", "Hansbeke", "Harchies", "Harelbeke", "Haren", "Haren-Sud/Haren-Zuid", "Hasselt", "Haute-Fl\u00C3\u00B4ne", "Haversin", "Havre", "Heide", "Heist", "Heist-op-den-Berg", "Heizijde", "Hemiksem", "Hennuy\u00C3\u00A8res", "Herent", "Herentals", "Hergenrath", "Herne", "Herseaux", "Herstal", "Herzele", "Heusden", "Hever", "Heverlee", "Hillegem", "Hoboken-Polder", "Hoeilaart", "Hofstade", "Holleken", "Hony", "Houraing", "Hourpes", "Houyet", "Hove", "Huizingen", "Huy", "Iddergem", "Idegem", "Ieper", "Ingelmunster", "Izegem", "Jambes", "Jambes-Est", "Jamioulx", "Jemappes", "Jemelle", "Jemeppe-sur-Meuse", "Jemeppe-sur-Sambre", "Jette", "Jurbeke", "Juslenville", "Kalmthout", "Kapelle-op-den-Bos", "Kapellen", "Kessel", "Kiewit", "Kijkuit", "Knokke", "Koksijde", "Kontich", "Kortemark", "Kortenberg", "Kortrijk", "Kwatrecht", "La Hulpe", "La Louvi\u00C3\u00A8re-Centre", "La Louvi\u00C3\u00A8re-Sud", "La Roche (Brabant)", "Labuissi\u00C3\u00A8re", "Landegem", "Landelies", "Landen", "Landskouter", "Langdorp", "Le Campinaire", "Lebbeke", "Lede", "Leignon", "Leman", "Lembeek", "Lens", "Leopoldsburg", "Lessen", "Leuven", "Leuze", "Leval", "Libramont", "Lichtervelde", "Liedekerke", "Li\u00C3\u00A8ge-Guillemins", "Li\u00C3\u00A8ge-Jonfosse", "Li\u00C3\u00A8ge-Palais", "Lier", "Lierde", "Liers", "Ligny", "Lillois", "Limal", "Linkebeek", "Lissewege", "Lobbes", "Lodelinsart", "Lokeren", "Lommel", "Londerzeel", "Lonz\u00C3\u00A9e", "Lot", "Louvain-la-Neuve-Universit\u00C3\u00A9", "Lustin", "Luttre", "Maffle", "Malderen", "Manage", "Marbehan", "Marche-en-Famenne", "Marche-les-Dames", "Marche-lez-\u00C3\u2030caussinnes", "Marchienne-au-Pont", "Marchienne-Zone", "Maria-Aalter", "Mariembourg", "Marloie", "Masnuy-Saint-Pierre", "Maubray", "Mazy", "Mechelen", "Mechelen-Nekkerspoel", "Meiser", "Melkouwen", "Melle", "Melreux-Hotton", "Melsele", "Menen", "Merchtem", "Merelbeke", "Merode", "M\u00C3\u00A9ry", "Messancy", "Mevergnies-Attre", "Michelau", "Milmort", "Moensberg", "Mouscron", "Mol", "Mollem", "Momalle", "Mons", "Mont-Saint-Guibert", "Moortsele", "Morlanwelz", "Mortsel", "Mortsel-Deurnesteenweg", "Mortsel-Liersesteenweg", "Mortsel-Oude God", "Moustier", "Muizen", "Munkzwalm", "Nam\u00C3\u00AAche", "Namur", "Naninne", "Natoye", "Neerpelt", "Neerwinden", "Nessonvaux", "Neufch\u00C3\u00A2teau", "Neufvilles", "Niel", "Nieuwkerken-Waas", "Nijlen", "Nimy", "Ninove", "Nivelles", "Noorderkempen", "Nossegem", "Obaix-Buzet", "Obourg", "Okegem", "Olen", "Oostende", "Oostkamp", "Opwijk", "Ottignies", "Oud-Heverlee", "Oudegem", "Oudenaarde", "Overpelt", "Paliseul", "Papegem", "P\u00C3\u00A9crot", "Pepinster", "Pepinster-Cit\u00C3\u00A9", "P\u00C3\u00A9ruwelz", "Philippeville", "Pi\u00C3\u00A9ton", "Poix-Saint-Hubert", "Pont-\u00C3\u00A0-Celles", "Pont-de-Seraing", "Poperinge", "Poulseur", "Profondsart", "Pry", "Puurs", "Quaregnon", "Quevy", "Quievrain", "Rebaix", "Remicourt", "Ronse", "Rhisnes", "Sint-Genesius-Rode", "Rivage", "Rixensart", "Roeselare", "Ronet", "Roux", "Ruisbroek", "Ruisbroek-Sauvegarde", "Saint-Denis-Bovesse", "Saint-Ghislain", "Sint-Job", "Sart-Bernard", "Schaarbeek/Schaerbeek", "Scheldewindeke", "Schelle", "Schellebelle", "Schendelbeke", "Schoonaarde", "Schulen", "Sclaigneaux", "Sclessin", "Serskamp", "Silly", "Simonis", "Sinaai", "Sint-Denijs-Boekel", "Sint-Gillis-Dendermonde", "Sint-Joris-Weert", "Sint-Katelijne-Waver", "Sint-Mariaburg", "Sint-Martens-Bodegem", "Sint-Niklaas", "Sint-Truiden", "Sleidinge", "Soignies", "Solre-sur-Sambre", "Spa", "Spa-G\u00C3\u00A9ronst\u00C3\u00A8re", "Statte", "Stockem", "Sy", "Tamines", "Temse", "Terhagen", "Ternat", "Testelt", "Theux", "Thieu", "Thuin", "Thulin", "Tielen", "Tielt", "Tienen", "Tilff", "Tilly", "Tollembeek", "Tongeren", "Torhout", "Tournai", "Trois-Ponts", "Trooz", "Tubize", "Turnhout", "Ukkel-Kalevoet/Uccle-Calevoet", "Ukkel-Stalle/Uccle-Stalle", "Veltem", "Vertrijk", "Verviers-Central", "Verviers-Palais", "Veurne", "Viane-Moerbeke", "Vichte", "Vielsalm", "Vijfhuizen", "Ville-Pommer\u00C5\u201Cul", "Villers-la-Ville", "Vilvoorde", "Virton", "Vis\u00C3\u00A9", "Viville", "Voroux", "Waarschoot", "Walcourt", "Waregem", "Waremme", "Waterloo", "Watermaal", "Wavre", "Weerde", "Welkenraedt", "Welle", "Wervik", "Wespelaar-Tildonk", "Wetteren", "Wevelgem", "Wezemaal", "Wichelen", "Wijgmaal", "Wildert", "Willebroek", "Wolfstee", "Wondelgem", "Yves-Gomez\u00C3\u00A9e", "Yvoir", "Zandbergen", "Zaventem", "Zedelgem", "Zeebrugge-Dorp", "Zeebrugge-Strand", "Zele", "Zellik", "Zichem", "Zingem", "Zolder", "Zonhoven", "Zottegem", "Zwankendamme", "Zwijndrecht", "Amsterdam CS", "Den Haag HS", "Dordrecht", "Eijsden", "Maastricht", "Maastricht Randwyck", "Roosendaal", "Rotterdam CS", "Schiphol", "A\u00C3\u00A9roport Charles-de-Gaulle TGV", "Haute-Picardie TGV", "Aix-en-Provence TGV", "Annappes", "Antibes", "Ascq", "Avignon TGV", "Baisieux", "Cannes", "Colmar", "Croix l'Allumette", "Croix Wasquehal", "Hellemmes", "Les Arcs - Draguignan", "Lezennes", "Lille Europe", "Lille Flandres", "Lyon Part Dieu TGV", "Lyon-Perrache TGV", "Lyon-Saint Exup\u00C3\u00A9ry TGV", "Marne-la-Vall\u00C3\u00A9e - Chessy", "Marseille-Saint-Charles", "Metz", "Montpellier", "Mulhouse", "Nice Ville", "N\u00C3\u00AEmes", "Paris Nord", "Pont de Bois", "Roubaix", "Saint-Louis-Haut-Rhin", "Saint-Rapha\u00C3\u00ABl-Valescure", "Saverne", "Selestat", "Strasbourg", "Thionville", "Narbonne", "B\u00C3\u00A9ziers", "Chamb\u00C3\u00A9ry-Challes-les-Eaux", "Albertville", "Mo\u00C3\u00BBtiers-Salins-Brides-les-Bai", "Aime-la-Plagne", "Landry", "Bourg-Saint-Maurice", "Agde", "S\u00C3\u00A8te", "Perpignan", "Toulon", "Tourcoing", "Valence TGV", "Aachen Hbf", "D\u00C3\u00BCsseldorf Hbf", "D\u00C3\u00BCsseldorf Flughafen Hbf", "Essen Hbf", "Duisburg Hbf", "Frankfurt am Main Flughafen", "Frankfurt am Main Hbf", "K\u00C3\u00B6ln Hbf", "Siegburg", "Limburg S\u00C3\u00BCd", "Bertrange Strassen", "Clervaux", "Drauffelt", "Ettelbr\u00C3\u00A9ck", "Capellen", "Kautebaach", "Klengbetten", "L\u00C3\u00ABtzebuerg", "Mamer", "Mamer-Lyc\u00C3\u00A9e", "Mersch", "Rodange", "Troisvierges", "Wilwerwiltz", "Basel", "Ebbsfleet International", "London Saint Pancras International", "Thurn en Taxis", "Mouterij", "Arcaden"}));
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox_1, -3, SpringLayout.NORTH, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_1, 6, SpringLayout.EAST, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_1, 106, SpringLayout.EAST, lblEindstation);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Aalst", "Aalst-Kerrebroek", "Aalter", "Aarschot", "Aarsele", "Acren", "Aiseau", "Alken", "Amay", "Ampsin", "Andenne", "Angleur", "Ans", "Anseremme", "Antoing", "Antwerpen-Berchem", "Antwerpen-Centraal", "Antwerpen-Haven", "Antwerpen-Luchtbal", "Antwerpen-Noorderdokken", "Antwerpen-Oost", "Antwerpen-Zuid", "Anzegem", "Appelterre", "Archennes", "Arlon", "Asse", "Assesse", "Ath", "Athus", "Aubange", "Auvelais", "Aye", "Aywaille", "Baasrode-Zuid", "Balegem-Dorp", "Balegem-Zuid", "Balen", "Bambrugge", "Barvaux", "Bas-Oha", "Basse-Wavre", "Bastogne-Nord", "Bastogne-Sud", "Beauraing", "Beernem", "Beersel", "Beervelde", "Begijnendijk", "Beign\u00C3\u00A9e", "Bellem", "Belsele", "Sint-Agatha-Berchem/Berchem-Sainte-Agathe", "Beringen", "Berlaar", "Bertrix", "Berz\u00C3\u00A9e", "Beuzet", "Beveren", "Beverlo", "Bierges-Walibi", "Bierset-Awans", "Bilzen", "Binche", "Bissegem", "Blankenberge", "Blanmont", "Blaton", "Bleret", "Bockstael", "Boechout", "Bosvoorde/Boitsfort", "Bokrijk", "Bomal", "Booischot", "Boom", "Boondaal/Boondael", "Boortmeerbeek", "Bordet", "Bornem", "Boussu", "Bouwel", "Bracquegnies", "Braine-l'Alleud", "Braine-le-Comte", "Bressoux", "Brugelette", "Brugge", "Brugge-Sint-Pieters", "Brussel-Centraal/Bruxelles-Central", "Brussel-Congres/Bruxelles-Congr\u00C3\u00A8s", "Brussel-Kapellekerk/Bruxelles-Chapelle", "Brussel-Luxemburg/Bruxelles-Luxembourg", "Brussels Airport - Zaventem", "Brussel-Noord/Bruxelles-Nord", "Brussel-Schuman/Bruxelles-Schuman", "Brussel-West/Bruxelles-Ouest", "Brussel-Zuid/Bruxelles-Midi", "Buda", "Buggenhout", "Buizingen", "Burst", "Callenelle", "Cambron-Casteau", "Carlsbourg", "Carnieres", "Ceroux-Mousty", "Chapelle-Dieu", "Chapois", "Charleroi-Ouest", "Charleroi-Sud", "Chastre", "Ch\u00C3\u00A2teau-de-Seilles", "Ch\u00C3\u00A2telet", "Ch\u00C3\u00AAn\u00C3\u00A9e", "Ciney", "Comblain-la-Tour", "Comines", "Coo", "Couillet", "Cour-sur-Heure", "Courcelles-Motte", "Courri\u00C3\u00A8re", "Court-Saint-\u00C3\u2030tienne", "Couvin", "Dave-Saint-Martin", "De Hoek", "De Panne", "De Pinte", "Deinze", "Delta", "Denderleeuw", "Dendermonde", "Diegem", "Diepenbeek", "Diesdelle/Vivier d'Oie", "Diest", "Diksmuide", "Dilbeek", "Dinant", "Dolhain-Gileppe", "Dortmund Hbf", "Drongen", "Duffel", "Duinbergen", "\u00C3\u2030caussinnes", "Ede", "Enghien", "Eeklo", "Eichem", "Eine", "Eke-Nazareth", "Ekeren", "Engis", "Eppegem", "Erbis\u00C5\u201Cul", "Erembodegem", "Ernage", "Erpe-Mere", "Erps-Kwerps", "Erquelinnes", "Erquelinnes-Village", "Esneux", "Essen", "Essene-Lombeek", "Etterbeek", "Eupen", "Evere", "Evergem", "Ezemaal", "Familleureux", "Farciennes", "Faux", "Fexhe-le-Haut-Clocher", "Flawinne", "Flemalle-Grande", "Flemalle-Haute", "Fleurus", "Flor\u00C3\u00A9e", "Floreffe", "Florenville", "Florival", "Fontaine-Valmont", "Forchies", "Vorst-Oost/Forest-Est", "Vorst-Zuid/Forest-Midi", "Forri\u00C3\u00A8res", "Fraipont", "Frameries", "Franchimont", "Frani\u00C3\u00A8re", "Froyennes", "Galmaarden", "Gastuche", "Gavere-Asper", "Gedinne", "Geel", "Gembloux", "Gendron-Celles", "Genk", "Genly", "Gent-Dampoort", "Gent-Sint-Pieters", "Gentbrugge", "Genval", "Geraardsbergen", "Ghlin", "Glons", "Godarville", "Godinne", "Gontrode", "Gouvy", "Gouy-lez-Pieton", "Graide", "Groenendaal", "Groot-Bijgaarden", "Grupont", "Haacht", "Haaltert", "Habay", "Hainin", "Halanzy", "Halle", "Ham-sur-Heure", "Ham-sur-Sambre", "Hambos", "Hamoir", "Hamont", "Hansbeke", "Harchies", "Harelbeke", "Haren", "Haren-Sud/Haren-Zuid", "Hasselt", "Haute-Fl\u00C3\u00B4ne", "Haversin", "Havre", "Heide", "Heist", "Heist-op-den-Berg", "Heizijde", "Hemiksem", "Hennuy\u00C3\u00A8res", "Herent", "Herentals", "Hergenrath", "Herne", "Herseaux", "Herstal", "Herzele", "Heusden", "Hever", "Heverlee", "Hillegem", "Hoboken-Polder", "Hoeilaart", "Hofstade", "Holleken", "Hony", "Houraing", "Hourpes", "Houyet", "Hove", "Huizingen", "Huy", "Iddergem", "Idegem", "Ieper", "Ingelmunster", "Izegem", "Jambes", "Jambes-Est", "Jamioulx", "Jemappes", "Jemelle", "Jemeppe-sur-Meuse", "Jemeppe-sur-Sambre", "Jette", "Jurbeke", "Juslenville", "Kalmthout", "Kapelle-op-den-Bos", "Kapellen", "Kessel", "Kiewit", "Kijkuit", "Knokke", "Koksijde", "Kontich", "Kortemark", "Kortenberg", "Kortrijk", "Kwatrecht", "La Hulpe", "La Louvi\u00C3\u00A8re-Centre", "La Louvi\u00C3\u00A8re-Sud", "La Roche (Brabant)", "Labuissi\u00C3\u00A8re", "Landegem", "Landelies", "Landen", "Landskouter", "Langdorp", "Le Campinaire", "Lebbeke", "Lede", "Leignon", "Leman", "Lembeek", "Lens", "Leopoldsburg", "Lessen", "Leuven", "Leuze", "Leval", "Libramont", "Lichtervelde", "Liedekerke", "Li\u00C3\u00A8ge-Guillemins", "Li\u00C3\u00A8ge-Jonfosse", "Li\u00C3\u00A8ge-Palais", "Lier", "Lierde", "Liers", "Ligny", "Lillois", "Limal", "Linkebeek", "Lissewege", "Lobbes", "Lodelinsart", "Lokeren", "Lommel", "Londerzeel", "Lonz\u00C3\u00A9e", "Lot", "Louvain-la-Neuve-Universit\u00C3\u00A9", "Lustin", "Luttre", "Maffle", "Malderen", "Manage", "Marbehan", "Marche-en-Famenne", "Marche-les-Dames", "Marche-lez-\u00C3\u2030caussinnes", "Marchienne-au-Pont", "Marchienne-Zone", "Maria-Aalter", "Mariembourg", "Marloie", "Masnuy-Saint-Pierre", "Maubray", "Mazy", "Mechelen", "Mechelen-Nekkerspoel", "Meiser", "Melkouwen", "Melle", "Melreux-Hotton", "Melsele", "Menen", "Merchtem", "Merelbeke", "Merode", "M\u00C3\u00A9ry", "Messancy", "Mevergnies-Attre", "Michelau", "Milmort", "Moensberg", "Mouscron", "Mol", "Mollem", "Momalle", "Mons", "Mont-Saint-Guibert", "Moortsele", "Morlanwelz", "Mortsel", "Mortsel-Deurnesteenweg", "Mortsel-Liersesteenweg", "Mortsel-Oude God", "Moustier", "Muizen", "Munkzwalm", "Nam\u00C3\u00AAche", "Namur", "Naninne", "Natoye", "Neerpelt", "Neerwinden", "Nessonvaux", "Neufch\u00C3\u00A2teau", "Neufvilles", "Niel", "Nieuwkerken-Waas", "Nijlen", "Nimy", "Ninove", "Nivelles", "Noorderkempen", "Nossegem", "Obaix-Buzet", "Obourg", "Okegem", "Olen", "Oostende", "Oostkamp", "Opwijk", "Ottignies", "Oud-Heverlee", "Oudegem", "Oudenaarde", "Overpelt", "Paliseul", "Papegem", "P\u00C3\u00A9crot", "Pepinster", "Pepinster-Cit\u00C3\u00A9", "P\u00C3\u00A9ruwelz", "Philippeville", "Pi\u00C3\u00A9ton", "Poix-Saint-Hubert", "Pont-\u00C3\u00A0-Celles", "Pont-de-Seraing", "Poperinge", "Poulseur", "Profondsart", "Pry", "Puurs", "Quaregnon", "Quevy", "Quievrain", "Rebaix", "Remicourt", "Ronse", "Rhisnes", "Sint-Genesius-Rode", "Rivage", "Rixensart", "Roeselare", "Ronet", "Roux", "Ruisbroek", "Ruisbroek-Sauvegarde", "Saint-Denis-Bovesse", "Saint-Ghislain", "Sint-Job", "Sart-Bernard", "Schaarbeek/Schaerbeek", "Scheldewindeke", "Schelle", "Schellebelle", "Schendelbeke", "Schoonaarde", "Schulen", "Sclaigneaux", "Sclessin", "Serskamp", "Silly", "Simonis", "Sinaai", "Sint-Denijs-Boekel", "Sint-Gillis-Dendermonde", "Sint-Joris-Weert", "Sint-Katelijne-Waver", "Sint-Mariaburg", "Sint-Martens-Bodegem", "Sint-Niklaas", "Sint-Truiden", "Sleidinge", "Soignies", "Solre-sur-Sambre", "Spa", "Spa-G\u00C3\u00A9ronst\u00C3\u00A8re", "Statte", "Stockem", "Sy", "Tamines", "Temse", "Terhagen", "Ternat", "Testelt", "Theux", "Thieu", "Thuin", "Thulin", "Tielen", "Tielt", "Tienen", "Tilff", "Tilly", "Tollembeek", "Tongeren", "Torhout", "Tournai", "Trois-Ponts", "Trooz", "Tubize", "Turnhout", "Ukkel-Kalevoet/Uccle-Calevoet", "Ukkel-Stalle/Uccle-Stalle", "Veltem", "Vertrijk", "Verviers-Central", "Verviers-Palais", "Veurne", "Viane-Moerbeke", "Vichte", "Vielsalm", "Vijfhuizen", "Ville-Pommer\u00C5\u201Cul", "Villers-la-Ville", "Vilvoorde", "Virton", "Vis\u00C3\u00A9", "Viville", "Voroux", "Waarschoot", "Walcourt", "Waregem", "Waremme", "Waterloo", "Watermaal", "Wavre", "Weerde", "Welkenraedt", "Welle", "Wervik", "Wespelaar-Tildonk", "Wetteren", "Wevelgem", "Wezemaal", "Wichelen", "Wijgmaal", "Wildert", "Willebroek", "Wolfstee", "Wondelgem", "Yves-Gomez\u00C3\u00A9e", "Yvoir", "Zandbergen", "Zaventem", "Zedelgem", "Zeebrugge-Dorp", "Zeebrugge-Strand", "Zele", "Zellik", "Zichem", "Zingem", "Zolder", "Zonhoven", "Zottegem", "Zwankendamme", "Zwijndrecht", "Amsterdam CS", "Den Haag HS", "Dordrecht", "Eijsden", "Maastricht", "Maastricht Randwyck", "Roosendaal", "Rotterdam CS", "Schiphol", "A\u00C3\u00A9roport Charles-de-Gaulle TGV", "Haute-Picardie TGV", "Aix-en-Provence TGV", "Annappes", "Antibes", "Ascq", "Avignon TGV", "Baisieux", "Cannes", "Colmar", "Croix l'Allumette", "Croix Wasquehal", "Hellemmes", "Les Arcs - Draguignan", "Lezennes", "Lille Europe", "Lille Flandres", "Lyon Part Dieu TGV", "Lyon-Perrache TGV", "Lyon-Saint Exup\u00C3\u00A9ry TGV", "Marne-la-Vall\u00C3\u00A9e - Chessy", "Marseille-Saint-Charles", "Metz", "Montpellier", "Mulhouse", "Nice Ville", "N\u00C3\u00AEmes", "Paris Nord", "Pont de Bois", "Roubaix", "Saint-Louis-Haut-Rhin", "Saint-Rapha\u00C3\u00ABl-Valescure", "Saverne", "Selestat", "Strasbourg", "Thionville", "Narbonne", "B\u00C3\u00A9ziers", "Chamb\u00C3\u00A9ry-Challes-les-Eaux", "Albertville", "Mo\u00C3\u00BBtiers-Salins-Brides-les-Bai", "Aime-la-Plagne", "Landry", "Bourg-Saint-Maurice", "Agde", "S\u00C3\u00A8te", "Perpignan", "Toulon", "Tourcoing", "Valence TGV", "Aachen Hbf", "D\u00C3\u00BCsseldorf Hbf", "D\u00C3\u00BCsseldorf Flughafen Hbf", "Essen Hbf", "Duisburg Hbf", "Frankfurt am Main Flughafen", "Frankfurt am Main Hbf", "K\u00C3\u00B6ln Hbf", "Siegburg", "Limburg S\u00C3\u00BCd", "Bertrange Strassen", "Clervaux", "Drauffelt", "Ettelbr\u00C3\u00A9ck", "Capellen", "Kautebaach", "Klengbetten", "L\u00C3\u00ABtzebuerg", "Mamer", "Mamer-Lyc\u00C3\u00A9e", "Mersch", "Rodange", "Troisvierges", "Wilwerwiltz", "Basel", "Ebbsfleet International", "London Saint Pancras International", "Thurn en Taxis", "Mouterij", "Arcaden"}));
		add(comboBox_1);
		
		JLabel lblDatum = new JLabel("Datum");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDatum, 0, SpringLayout.NORTH, lblEindstation);
		add(lblDatum);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 106, SpringLayout.EAST, lblDatum);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblHeenenterugreis = new JLabel("Heen-en-terugreis");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDatum, 0, SpringLayout.WEST, lblHeenenterugreis);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblHeenenterugreis, 30, SpringLayout.EAST, comboBox);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblHeenenterugreis, 0, SpringLayout.SOUTH, lblBeginstation);
		add(lblHeenenterugreis);
		
		JCheckBox checkBox = new JCheckBox("");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, checkBox, 0, SpringLayout.SOUTH, comboBox);
		sl_contentPane.putConstraint(SpringLayout.EAST, checkBox, 0, SpringLayout.EAST, textField);
		add(checkBox);
		
		JLabel lblTypeTicket = new JLabel("Type ticket");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTypeTicket, 16, SpringLayout.SOUTH, lblEindstation);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTypeTicket, 0, SpringLayout.EAST, lblBeginstation);
		add(lblTypeTicket);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Type 1"}));
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_2, 0, SpringLayout.WEST, comboBox);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox_2, 0, SpringLayout.SOUTH, lblTypeTicket);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_2, 106, SpringLayout.EAST, lblTypeTicket);
		add(comboBox_2);
		
		JButton btnOfferte = new JButton("Offerte");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnOfferte, 51, SpringLayout.SOUTH, comboBox_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnOfferte, 0, SpringLayout.EAST, comboBox);
		add(btnOfferte);
		
		JButton btnKoopTicket = new JButton("Koop Ticket");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnKoopTicket, 13, SpringLayout.SOUTH, btnOfferte);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnKoopTicket, 0, SpringLayout.EAST, comboBox);
		add(btnKoopTicket);
		
		txtPrijs = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtPrijs, 0, SpringLayout.WEST, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtPrijs, 0, SpringLayout.SOUTH, btnOfferte);
		add(txtPrijs);
		txtPrijs.setColumns(10);
		
		JLabel lblPrijs = new JLabel("Prijs");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPrijs, 0, SpringLayout.WEST, lblDatum);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPrijs, -6, SpringLayout.NORTH, txtPrijs);
		add(lblPrijs);
		
		JButton button = new JButton("<<  Terug");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionMenuController.switchToActionMenuView();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 10, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, -10, SpringLayout.SOUTH, this);
		add(button);

	}
}

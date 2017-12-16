/*
 *   Classname: Kleinbaer
 *
 *   Version: 1.0 [created 5th ADAP-homework]
 *
 *   Date: 11.11.2017
 *
 */
package org.wahlzeit.model;

/**
 * Kleinbaer-Class represents a specific Kleinbaer
 */
public class Kleinbaer {

    /**
     * the scientific Declaration of Kleinbaer
     */
    private final String SCIENTIFIC_NAME = "Procyonidae";

    /**
     * the genus of a Kleinbaer
     */
    private kleinbaerengenus genus;


    /**
     * Accepted genera of Kleinbaer, mainly extinct genera are ignored
     */
    public enum kleinbaerengenus {
        MAKIBAER, WICKELBAER, KATZENFRETT, WASCHBAER, NASENBAER, BERNASENBAER
    }

    /**
     * The number of teeth a typical Kleinbaer-Genera has
     * Fun Fact: Kleinbaer have 40 teeth, Wickelbaeren have one less per row(total of 36)
     */
    private int numberOfTeeth;

    /**
     * Max weight of the Kleinbaer-Genus in gram
     */
    private int maxWeight;

    /**
     * Max tail length of the Kleinbaer-Genus in cm
     */
    private int maxTailLength;

    /**
     * max length of the Kleinbaer-Genus without counting the tail in cm
     */
    private int maxSnoutVentLength;

    /**
     * @methodtype initialize
     * initialized all the Kleinbaerfacts and the genus of the Kleinbaer
     * @param genus for which the Kleinbaerfacts are set
     */
    public Kleinbaer(kleinbaerengenus genus){
        assertGenusNotNull(genus);

        updateKleinbaerfacts(genus);
    }

    /**
     * @methodtyp get
     * @return the scientific family declaration for Kleinbaren
     */
    public String getSCIENTIFIC_NAME() {
        return SCIENTIFIC_NAME;
    }

    /**
     * @methodtype get
     * @return genus of the Kleinbaer
     */
    public kleinbaerengenus getGenus(){
        assertGenusNotNull(genus);

        return genus;
    }

    /**
     * @methodtype set
     * @param newGenus Kleinbaer-Genus which is to be set
     */
    public void setGenus(kleinbaerengenus newGenus){
        assertGenusNotNull(genus);

        updateKleinbaerfacts(newGenus);
        genus = newGenus;
    }

    /**
     * @methodtype get
     * @return the number of teeth the Kleinbaer has
     */
    public int getNumberOfTeeth(){
        return numberOfTeeth;
    }

    /**
     * @methodtype set
     * @param genus for which the typical number of teeth get set
     */
    private void setNumberOfTeeth(kleinbaerengenus genus){
        assertGenusNotNull(genus);

        if(genus == kleinbaerengenus.WICKELBAER){
            this.numberOfTeeth = 36;
            return;
        }
        this.numberOfTeeth = 40;
        return;
    }

    /**
     * @methodtype set
     * @param numberOfTeeth sets a specific amount of Teeth for a Kleinbaer
     */
    public void setNumberOfTeeth(int numberOfTeeth){
        if(numberOfTeeth < 0){
            throw new IllegalArgumentException();
        }
        this.numberOfTeeth = numberOfTeeth;
    }

    /**
     * @methodtype get
     * @return maxWeight of the Kleinbaer in gramms
     */
    public int getMaxWeight(){
        return maxWeight;
    }

    /**
     * @methodtype get
     * @return maxTailLength of the Kleinbaer in cm
     */
    public int getMaxTailLength(){
        return maxTailLength;
    }

    /**
     * @methodtype get
     * @return maxSnoutVentLength of the Kleinbaer in cm
     */
    public int getMaxSnoutVentLength(){
        return maxSnoutVentLength;
    }

    /**
     * @methodtype set
     * @param genus sets the maxWeight for this genus in gramms
     */
    private void setMaxWeight(kleinbaerengenus genus){
        assertGenusNotNull(genus);

        switch (genus){
            case MAKIBAER:
                this.maxWeight = 1_500;
                break;
            case NASENBAER:
                this.maxWeight = 6_000;
                break;
            case WASCHBAER:
                this.maxWeight = 12_000;
                break;
            case WICKELBAER:
                this.maxWeight = 4_600;
                break;
            case KATZENFRETT:
                this.maxWeight = 1_300;
                break;
            case BERNASENBAER:
                this.maxWeight = 1_500;
                break;
            default:
                this.maxWeight = 12_000;
        }
    }

    /**
     * @methodtype set
     * @param genus sets the max tail length for this genus in cm
     */
    private void setMaxTailLength(kleinbaerengenus genus){
        assertGenusNotNull(genus);

        switch (genus){
            case MAKIBAER:
                this.maxTailLength = 48;
                break;
            case NASENBAER:
                this.maxTailLength = 68;
                break;
            case WASCHBAER:
                this.maxTailLength = 40;
                break;
            case WICKELBAER:
                this.maxTailLength = 55;
                break;
            case KATZENFRETT:
                this.maxTailLength = 44;
                break;
            case BERNASENBAER:
                this.maxTailLength = 24;
                break;
            default:
                this.maxWeight = 68;
        }
    }

    /**
     * @methodtype set
     * @param genus sets the max length(without the tail) for this genus in cm
     */
    private void setMaxSnoutVentLength(kleinbaerengenus genus){
        assertGenusNotNull(genus);

        switch (genus){
            case MAKIBAER:
                this.maxSnoutVentLength = 48;
                break;
            case NASENBAER:
                this.maxSnoutVentLength = 70;
                break;
            case WASCHBAER:
                this.maxSnoutVentLength = 60;
                break;
            case WICKELBAER:
                this.maxSnoutVentLength = 60;
                break;
            case KATZENFRETT:
                this.maxSnoutVentLength = 42;
                break;
            case BERNASENBAER:
                this.maxSnoutVentLength = 39;
                break;
            default:
                this.maxWeight = 70;
        }
    }

    /**
     * @methodtyp set
     * Method sets all Facts for the new genus
     * @param newGenus the genus for which the global variables are updated
     */
    private void updateKleinbaerfacts(kleinbaerengenus newGenus){
        assertGenusNotNull(newGenus);

        setNumberOfTeeth(newGenus);
        setMaxWeight(newGenus);
        setMaxSnoutVentLength(newGenus);
        setMaxTailLength(newGenus);
    }
    /**
     * ------------------------ Assertions ------------------------
     */

    /**
     * Asserts that the given genus is not null
     * @methodtype assertion
     * @throws KleinbaerException if given kleinbaerengenus is null
     */
    private void assertGenusNotNull(kleinbaerengenus genus){
        if(genus == null){
            throw new KleinbaerException("kleinbaerengenus mustn't be null");
        }
    }

}

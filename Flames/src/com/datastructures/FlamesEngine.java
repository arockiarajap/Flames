/**
 * 
 */
package com.datastructures;

import com.utils.ImageLocations;

/**
 * @author Arockia
 *
 */
public class FlamesEngine {

	private volatile char[] flamesBoard = { 'F', 'L', 'A', 'M', 'E', 'S' };

	private Person male;

	private Person female;

	public FlamesEngine() {
	}

	public FlamesEngine(Person male, Person female) {
		this.male = male;
		this.female = female;
	}

	public Person getMale() {
		return male;
	}

	public void setMale(Person male) {
		this.male = male;
	}

	public Person getFemale() {
		return female;
	}

	public void setFemale(Person female) {
		this.female = female;
	}

	/**
	 * The process finds the relationship between the names which got set for
	 * this particular flames engine.
	 * 
	 * @return the relationship after processed.
	 */
	public String process() {
		int specialNumber = this.specialNumberOnPersons();
		int flamesBoardSize = flamesBoard.length;

		int counter = 0, boardCounter = 0, removedLetters = 0;
		while (boardCounter < flamesBoardSize) {
			char currentChar = flamesBoard[boardCounter];
			boolean isRemoved = currentChar == ' ' ? true : false;
			if (isRemoved) {
				if (boardCounter == flamesBoardSize - 1)
					boardCounter = 0;
				else
					boardCounter++;
				continue;
			} else if (!isRemoved) {
				counter++;
				if (counter == specialNumber) {
					flamesBoard[boardCounter] = ' ';
					removedLetters += 1;
					counter = 0;
				}
				if (removedLetters == 5)
					break;
				if (boardCounter == flamesBoardSize - 1) {
					boardCounter = 0;
					continue;
				}
				boardCounter++;
			}
		}

		String flamedChar = (new String(flamesBoard)).trim();
		return this.provideRelationship(flamedChar.charAt(0));
	}

	/**
	 * The provideRelationship finds the relationship image which needs to be
	 * displayed to the user.
	 * 
	 * @param falmedChar
	 *            the remaining character in the FLAMES.
	 * @return the image to display the found relationship
	 */
	private String provideRelationship(char falmedChar) {
		String relationship = null;
		switch (falmedChar) {
		case 'F':
			relationship = ImageLocations.friend;
			break;
		case 'L':
			relationship = ImageLocations.lover;
			break;
		case 'A':
			relationship = ImageLocations.affection;
			break;
		case 'M':
			relationship = ImageLocations.marriage;
			break;
		case 'E':
			relationship = ImageLocations.enemy;
			break;
		case 'S':
			relationship = ImageLocations.sister;
			break;
		}
		return relationship;
	}

	/**
	 * The specialNumberOnPersons finds the count after removing the common letters
	 * of the person names.
	 * 
	 * @return the count after removal of common letters only once on both
	 *         names.
	 */
	private int specialNumberOnPersons() {
		char[] maleName = male.toString().replace(" ", "").toUpperCase().toCharArray();
		char[] femaleName = female.toString().replace(" ", "").toUpperCase().toCharArray();

		// make common letters as hypen
		int maleNameSize = maleName.length;
		int femaleNameSize = femaleName.length;
		for (int maleNameCounter = 0; maleNameCounter < maleNameSize; maleNameCounter++) {
			for (int femaleNameCounter = 0; femaleNameCounter < femaleNameSize; femaleNameCounter++) {
				if (maleName[maleNameCounter] == femaleName[femaleNameCounter]) {
					maleName[maleNameCounter] = '-';
					femaleName[femaleNameCounter] = '-';
					break;
				}

			}
		}

		// find remaining letters
		int maleRemaingLetters = new String(maleName).replace("-", "").length();
		int femaleRemaingLetters = new String(femaleName).replace("-", "").length();
		int specialNumber = maleRemaingLetters + femaleRemaingLetters > 0 ? maleRemaingLetters + femaleRemaingLetters: 1;
		return specialNumber;
	}

}

package ru.kunik.ivaofriend.util;

public class IVAOGlobal {
	
	private static IVAOLanguage currentLanguage = IVAOLanguage.ENGLISH;
	
	public static IVAOLanguage getLanguage() {
		return currentLanguage;
	}
	
	public static void setLanguage(IVAOLanguage language) {
		currentLanguage = language;
	}
}

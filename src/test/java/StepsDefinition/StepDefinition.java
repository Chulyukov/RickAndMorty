package StepsDefinition;

import ApiSteps.Steps;
import Configuration.Configuration;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StepDefinition extends Steps {
   @Дано("^Вытаскиваем информацию по первому персонажу и проверяем статус код$")
   public void getFirstChar() {getFirstCharacter(Configuration.getConfigurationValue("firstCharacterId"));}

   @И("^Ищем последний эпизод и проверяем статус код$")
   public void getLastEp() {
       getLastEpisode();
   }

   @И("^Ищем id последнего персонажа и проверяем статус код$")
   public void getLastCharId() {getLastCharacterId();}

   @И("^Вытаскиваем информацию по последнему персонажу и проверяем статус код$")
   public void getLastCharInfo() {
        getLastCharacterInfo();
    }

   @Тогда("^Сравниваем расы$")
   public void getFirstCharacterInfo() {
       assertEquals(charSpecies, lastCharSpecies);
   }

   @Тогда("^Сравниваем локацию")
   public void checkCharactersLocations() {
       assertEquals(charLocation, lastCharLocation);
   }
}


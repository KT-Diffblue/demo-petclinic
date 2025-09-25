package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@ContextConfiguration(classes = {VisitController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class VisitControllerDiffblueTest {
  @MockBean private OwnerRepository ownerRepository;

  @Autowired private VisitController visitController;

  /**
   * Test {@link VisitController#loadPetWithVisit(int, int, Map)}.
   *
   * <ul>
   *   <li>Given {@link OwnerRepository} {@link OwnerRepository#findById(Integer)} return empty.
   * </ul>
   *
   * <p>Method under test: {@link VisitController#loadPetWithVisit(int, int, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPetWithVisit(int, int, Map); given OwnerRepository findById(Integer) return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Visit VisitController.loadPetWithVisit(int, int, Map)"})
  void testLoadPetWithVisit_givenOwnerRepositoryFindByIdReturnEmpty() {
    // Arrange
    Optional<Owner> emptyResult = Optional.empty();
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> visitController.loadPetWithVisit(1, 1, new HashMap<>()));
    verify(ownerRepository).findById(1);
  }

  /**
   * Test {@link VisitController#loadPetWithVisit(int, int, Map)}.
   *
   * <ul>
   *   <li>Given {@link OwnerRepository} {@link OwnerRepository#findById(Integer)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link VisitController#loadPetWithVisit(int, int, Map)}
   */
  @Test
  @DisplayName(
      "Test loadPetWithVisit(int, int, Map); given OwnerRepository findById(Integer) throw IllegalArgumentException()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Visit VisitController.loadPetWithVisit(int, int, Map)"})
  void testLoadPetWithVisit_givenOwnerRepositoryFindByIdThrowIllegalArgumentException() {
    // Arrange
    when(ownerRepository.findById(Mockito.<Integer>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> visitController.loadPetWithVisit(1, 1, new HashMap<>()));
    verify(ownerRepository).findById(1);
  }

  /**
   * Test {@link VisitController#initNewVisitForm()}.
   *
   * <p>Method under test: {@link VisitController#initNewVisitForm()}
   */
  @Test
  @DisplayName("Test initNewVisitForm()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String VisitController.initNewVisitForm()"})
  void testInitNewVisitForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals(
        "pets/createOrUpdateVisitForm",
        new VisitController(mock(OwnerRepository.class)).initNewVisitForm());
  }

  /**
   * Test {@link VisitController#processNewVisitForm(Owner, int, Visit, BindingResult,
   * RedirectAttributes)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code pets/createOrUpdateVisitForm}.
   * </ul>
   *
   * <p>Method under test: {@link VisitController#processNewVisitForm(Owner, int, Visit,
   * BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName(
      "Test processNewVisitForm(Owner, int, Visit, BindingResult, RedirectAttributes); given 'true'; then return 'pets/createOrUpdateVisitForm'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "String VisitController.processNewVisitForm(Owner, int, Visit, BindingResult, RedirectAttributes)"
  })
  void testProcessNewVisitForm_givenTrue_thenReturnPetsCreateOrUpdateVisitForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    VisitController visitController = new VisitController(mock(OwnerRepository.class));

    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Visit visit = new Visit();
    visit.setDate(LocalDate.of(1970, 1, 1));
    visit.setDescription("The characteristics of someone or something");
    visit.setId(1);

    BeanPropertyBindingResult result = mock(BeanPropertyBindingResult.class);
    when(result.hasErrors()).thenReturn(true);

    // Act
    String actualProcessNewVisitFormResult =
        visitController.processNewVisitForm(
            owner, 1, visit, result, new RedirectAttributesModelMap());

    // Assert
    verify(result).hasErrors();
    assertEquals("pets/createOrUpdateVisitForm", actualProcessNewVisitFormResult);
  }
}

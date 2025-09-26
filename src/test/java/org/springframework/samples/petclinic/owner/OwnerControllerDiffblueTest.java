package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ContextConfiguration(classes = {OwnerController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class OwnerControllerDiffblueTest {
  @Autowired private OwnerController ownerController;

  @MockBean private OwnerRepository ownerRepository;

  /**
   * Test {@link OwnerController#findOwner(Integer)}.
   *
   * <ul>
   *   <li>Given {@link Owner} (default constructor) Address is {@code 42 Main St}.
   *   <li>When one.
   *   <li>Then return {@link Owner} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#findOwner(Integer)}
   */
  @Test
  @DisplayName(
      "Test findOwner(Integer); given Owner (default constructor) Address is '42 Main St'; when one; then return Owner (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Owner OwnerController.findOwner(Integer)"})
  void testFindOwner_givenOwnerAddressIs42MainSt_whenOne_thenReturnOwner() {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    // Act
    Owner actualFindOwnerResult = ownerController.findOwner(1);

    // Assert
    verify(ownerRepository).findById(1);
    assertSame(owner, actualFindOwnerResult);
  }

  /**
   * Test {@link OwnerController#findOwner(Integer)}.
   *
   * <ul>
   *   <li>Given {@link OwnerRepository} {@link OwnerRepository#findById(Integer)} return empty.
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#findOwner(Integer)}
   */
  @Test
  @DisplayName("Test findOwner(Integer); given OwnerRepository findById(Integer) return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Owner OwnerController.findOwner(Integer)"})
  void testFindOwner_givenOwnerRepositoryFindByIdReturnEmpty() {
    // Arrange
    Optional<Owner> emptyResult = Optional.empty();
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ownerController.findOwner(1));
    verify(ownerRepository).findById(1);
  }

  /**
   * Test {@link OwnerController#findOwner(Integer)}.
   *
   * <ul>
   *   <li>Given {@link OwnerRepository} {@link OwnerRepository#findById(Integer)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#findOwner(Integer)}
   */
  @Test
  @DisplayName(
      "Test findOwner(Integer); given OwnerRepository findById(Integer) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Owner OwnerController.findOwner(Integer)"})
  void testFindOwner_givenOwnerRepositoryFindByIdThrowIllegalArgumentException() {
    // Arrange
    when(ownerRepository.findById(Mockito.<Integer>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ownerController.findOwner(1));
    verify(ownerRepository).findById(1);
  }

  /**
   * Test {@link OwnerController#findOwner(Integer)}.
   *
   * <ul>
   *   <li>Given {@link OwnerRepository}.
   *   <li>When {@code null}.
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#findOwner(Integer)}
   */
  @Test
  @DisplayName(
      "Test findOwner(Integer); given OwnerRepository; when 'null'; then return Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Owner OwnerController.findOwner(Integer)"})
  void testFindOwner_givenOwnerRepository_whenNull_thenReturnIdIsNull() {
    // Arrange and Act
    Owner actualFindOwnerResult = ownerController.findOwner(null);

    // Assert
    assertNull(actualFindOwnerResult.getId());
    assertNull(actualFindOwnerResult.getFirstName());
    assertNull(actualFindOwnerResult.getLastName());
    assertNull(actualFindOwnerResult.getAddress());
    assertNull(actualFindOwnerResult.getCity());
    assertNull(actualFindOwnerResult.getTelephone());
    assertTrue(actualFindOwnerResult.isNew());
  }

  /**
   * Test {@link OwnerController#initCreationForm()}.
   *
   * <p>Method under test: {@link OwnerController#initCreationForm()}
   */
  @Test
  @DisplayName("Test initCreationForm()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OwnerController.initCreationForm()"})
  void testInitCreationForm() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/new");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("owner"))
        .andExpect(view().name("owners/createOrUpdateOwnerForm"))
        .andExpect(forwardedUrl("owners/createOrUpdateOwnerForm"));
  }

  /**
   * Test {@link OwnerController#processCreationForm(Owner, BindingResult, RedirectAttributes)}.
   *
   * <p>Method under test: {@link OwnerController#processCreationForm(Owner, BindingResult,
   * RedirectAttributes)}
   */
  @Test
  @DisplayName("Test processCreationForm(Owner, BindingResult, RedirectAttributes)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OwnerController.processCreationForm(Owner, BindingResult, RedirectAttributes)"
  })
  void testProcessCreationForm() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners/new");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("owner"))
        .andExpect(view().name("owners/createOrUpdateOwnerForm"))
        .andExpect(forwardedUrl("owners/createOrUpdateOwnerForm"));
  }

  /**
   * Test {@link OwnerController#initFindForm()}.
   *
   * <p>Method under test: {@link OwnerController#initFindForm()}
   */
  @Test
  @DisplayName("Test initFindForm()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OwnerController.initFindForm()"})
  void testInitFindForm() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/find");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("owner"))
        .andExpect(view().name("owners/findOwners"))
        .andExpect(forwardedUrl("owners/findOwners"));
  }

  /**
   * Test {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}.
   *
   * <ul>
   *   <li>Given {@link Owner} (default constructor) Address is {@code 17 High St}.
   *   <li>Then model size five.
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
   */
  @Test
  @DisplayName(
      "Test processFindForm(int, Owner, BindingResult, Model); given Owner (default constructor) Address is '17 High St'; then model size five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OwnerController.processFindForm(int, Owner, BindingResult, Model)"})
  void testProcessFindForm_givenOwnerAddressIs17HighSt_thenModelSizeFive() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    Owner owner2 = new Owner();
    owner2.setAddress("17 High St");
    owner2.setCity("London");
    owner2.setFirstName("John");
    owner2.setId(2);
    owner2.setLastName("Smith");
    owner2.setTelephone("8605550118");

    ArrayList<Owner> content = new ArrayList<>();
    content.add(owner2);
    content.add(owner);
    when(ownerRepository.findByLastNameStartingWith(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/owners").param("page", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(5))
        .andExpect(
            model()
                .attributeExists("currentPage", "listOwners", "owner", "totalItems", "totalPages"))
        .andExpect(view().name("owners/ownersList"))
        .andExpect(forwardedUrl("owners/ownersList"));
  }

  /**
   * Test {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}.
   *
   * <ul>
   *   <li>Given {@link Owner} (default constructor) Address is {@code 42 Main St}.
   *   <li>Then status {@link StatusResultMatchers#isFound()}.
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
   */
  @Test
  @DisplayName(
      "Test processFindForm(int, Owner, BindingResult, Model); given Owner (default constructor) Address is '42 Main St'; then status isFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OwnerController.processFindForm(int, Owner, BindingResult, Model)"})
  void testProcessFindForm_givenOwnerAddressIs42MainSt_thenStatusIsFound() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");

    ArrayList<Owner> content = new ArrayList<>();
    content.add(owner);
    when(ownerRepository.findByLastNameStartingWith(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/owners").param("page", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(0))
        .andExpect(view().name("redirect:/owners/1"))
        .andExpect(redirectedUrl("/owners/1"));
  }

  /**
   * Test {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}.
   *
   * <ul>
   *   <li>When {@code Doe}.
   *   <li>Then model size one.
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
   */
  @Test
  @DisplayName(
      "Test processFindForm(int, Owner, BindingResult, Model); when 'Doe'; then model size one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OwnerController.processFindForm(int, Owner, BindingResult, Model)"})
  void testProcessFindForm_whenDoe_thenModelSizeOne() throws Exception {
    // Arrange
    when(ownerRepository.findByLastNameStartingWith(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/owners")
            .param("page", String.valueOf(1))
            .param("lastName", "Doe");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("owner"))
        .andExpect(view().name("owners/findOwners"))
        .andExpect(forwardedUrl("owners/findOwners"));
  }

  /**
   * Test {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequestBuilder#param(String, String[])} {@code page} is
   *       valueOf one.
   *   <li>Then model size one.
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#processFindForm(int, Owner, BindingResult, Model)}
   */
  @Test
  @DisplayName(
      "Test processFindForm(int, Owner, BindingResult, Model); when param(String, String[]) 'page' is valueOf one; then model size one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OwnerController.processFindForm(int, Owner, BindingResult, Model)"})
  void testProcessFindForm_whenParamPageIsValueOfOne_thenModelSizeOne() throws Exception {
    // Arrange
    when(ownerRepository.findByLastNameStartingWith(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/owners").param("page", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("owner"))
        .andExpect(view().name("owners/findOwners"))
        .andExpect(forwardedUrl("owners/findOwners"));
  }

  /**
   * Test {@link OwnerController#initUpdateOwnerForm()}.
   *
   * <p>Method under test: {@link OwnerController#initUpdateOwnerForm()}
   */
  @Test
  @DisplayName("Test initUpdateOwnerForm()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OwnerController.initUpdateOwnerForm()"})
  void testInitUpdateOwnerForm() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners/42/edit");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("owner"))
        .andExpect(view().name("owners/createOrUpdateOwnerForm"))
        .andExpect(forwardedUrl("owners/createOrUpdateOwnerForm"));
  }

  /**
   * Test {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int,
   * RedirectAttributes)}.
   *
   * <ul>
   *   <li>Given {@link Owner} (default constructor) Address is empty string.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int,
   * RedirectAttributes)}
   */
  @Test
  @DisplayName(
      "Test processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes); given Owner (default constructor) Address is empty string; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OwnerController.processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes)"
  })
  void testProcessUpdateOwnerForm_givenOwnerAddressIsEmptyString_thenStatusIsOk() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);

    Owner owner2 = new Owner();
    owner2.setAddress("42 Main St");
    owner2.setCity("Oxford");
    owner2.setFirstName("Jane");
    owner2.setId(1);
    owner2.setLastName("Doe");
    owner2.setTelephone("6625550144");
    when(ownerRepository.save(Mockito.<Owner>any())).thenReturn(owner2);
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/owners/{ownerId}/edit", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("owner"))
        .andExpect(view().name("owners/createOrUpdateOwnerForm"))
        .andExpect(forwardedUrl("owners/createOrUpdateOwnerForm"));
  }

  /**
   * Test {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int,
   * RedirectAttributes)}.
   *
   * <ul>
   *   <li>Then view name {@code redirect:/owners/{ownerId}}.
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int,
   * RedirectAttributes)}
   */
  @Test
  @DisplayName(
      "Test processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes); then view name 'redirect:/owners/{ownerId}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OwnerController.processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes)"
  })
  void testProcessUpdateOwnerForm_thenViewNameRedirectOwnersOwnerId() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);

    Owner owner2 = new Owner();
    owner2.setAddress("42 Main St");
    owner2.setCity("Oxford");
    owner2.setFirstName("Jane");
    owner2.setId(1);
    owner2.setLastName("Doe");
    owner2.setTelephone("6625550144");
    when(ownerRepository.save(Mockito.<Owner>any())).thenReturn(owner2);
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/owners/{ownerId}/edit", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(0))
        .andExpect(view().name("redirect:/owners/{ownerId}"))
        .andExpect(redirectedUrl("/owners/1"));
  }

  /**
   * Test {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int,
   * RedirectAttributes)}.
   *
   * <ul>
   *   <li>Then view name {@code redirect:/owners/{ownerId}/edit}.
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#processUpdateOwnerForm(Owner, BindingResult, int,
   * RedirectAttributes)}
   */
  @Test
  @DisplayName(
      "Test processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes); then view name 'redirect:/owners/{ownerId}/edit'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OwnerController.processUpdateOwnerForm(Owner, BindingResult, int, RedirectAttributes)"
  })
  void testProcessUpdateOwnerForm_thenViewNameRedirectOwnersOwnerIdEdit() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(2);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);

    Owner owner2 = new Owner();
    owner2.setAddress("42 Main St");
    owner2.setCity("Oxford");
    owner2.setFirstName("Jane");
    owner2.setId(1);
    owner2.setLastName("Doe");
    owner2.setTelephone("6625550144");
    when(ownerRepository.save(Mockito.<Owner>any())).thenReturn(owner2);
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/owners/{ownerId}/edit", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(0))
        .andExpect(view().name("redirect:/owners/{ownerId}/edit"))
        .andExpect(redirectedUrl("/owners/1/edit"));
  }

  /**
   * Test {@link OwnerController#showOwner(int)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Owner} (default constructor).
   *   <li>When empty string.
   *   <li>Then status {@link StatusResultMatchers#isFound()}.
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#showOwner(int)}
   */
  @Test
  @DisplayName(
      "Test showOwner(int); given ArrayList() add Owner (default constructor); when empty string; then status isFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.springframework.web.servlet.ModelAndView OwnerController.showOwner(int)"})
  void testShowOwner_givenArrayListAddOwner_whenEmptyString_thenStatusIsFound() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);

    Owner owner2 = new Owner();
    owner2.setAddress("42 Main St");
    owner2.setCity("Oxford");
    owner2.setFirstName("Jane");
    owner2.setId(1);
    owner2.setLastName("Doe");
    owner2.setTelephone("6625550144");

    ArrayList<Owner> content = new ArrayList<>();
    content.add(owner2);
    when(ownerRepository.findByLastNameStartingWith(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/owners/{ownerId}", "");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(0))
        .andExpect(view().name("redirect:/owners/1"))
        .andExpect(redirectedUrl("/owners/1"));
  }

  /**
   * Test {@link OwnerController#showOwner(int)}.
   *
   * <ul>
   *   <li>Given {@link Owner} (default constructor) Address is {@code 17 High St}.
   *   <li>When empty string.
   *   <li>Then model size five.
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#showOwner(int)}
   */
  @Test
  @DisplayName(
      "Test showOwner(int); given Owner (default constructor) Address is '17 High St'; when empty string; then model size five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.springframework.web.servlet.ModelAndView OwnerController.showOwner(int)"})
  void testShowOwner_givenOwnerAddressIs17HighSt_whenEmptyString_thenModelSizeFive()
      throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);

    Owner owner2 = new Owner();
    owner2.setAddress("42 Main St");
    owner2.setCity("Oxford");
    owner2.setFirstName("Jane");
    owner2.setId(1);
    owner2.setLastName("Doe");
    owner2.setTelephone("6625550144");

    Owner owner3 = new Owner();
    owner3.setAddress("17 High St");
    owner3.setCity("London");
    owner3.setFirstName("John");
    owner3.setId(2);
    owner3.setLastName("Smith");
    owner3.setTelephone("8605550118");

    ArrayList<Owner> content = new ArrayList<>();
    content.add(owner3);
    content.add(owner2);
    when(ownerRepository.findByLastNameStartingWith(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/owners/{ownerId}", "");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(5))
        .andExpect(
            model()
                .attributeExists("currentPage", "listOwners", "owner", "totalItems", "totalPages"))
        .andExpect(view().name("owners/ownersList"))
        .andExpect(forwardedUrl("owners/ownersList"));
  }

  /**
   * Test {@link OwnerController#showOwner(int)}.
   *
   * <ul>
   *   <li>Then view name {@code owners/findOwners}.
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#showOwner(int)}
   */
  @Test
  @DisplayName("Test showOwner(int); then view name 'owners/findOwners'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.springframework.web.servlet.ModelAndView OwnerController.showOwner(int)"})
  void testShowOwner_thenViewNameOwnersFindOwners() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);
    when(ownerRepository.findByLastNameStartingWith(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/owners/{ownerId}", "");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("owner"))
        .andExpect(view().name("owners/findOwners"))
        .andExpect(forwardedUrl("owners/findOwners"));
  }

  /**
   * Test {@link OwnerController#showOwner(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then view name {@code owners/ownerDetails}.
   * </ul>
   *
   * <p>Method under test: {@link OwnerController#showOwner(int)}
   */
  @Test
  @DisplayName("Test showOwner(int); when one; then view name 'owners/ownerDetails'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.springframework.web.servlet.ModelAndView OwnerController.showOwner(int)"})
  void testShowOwner_whenOne_thenViewNameOwnersOwnerDetails() throws Exception {
    // Arrange
    Owner owner = new Owner();
    owner.setAddress("42 Main St");
    owner.setCity("Oxford");
    owner.setFirstName("Jane");
    owner.setId(1);
    owner.setLastName("Doe");
    owner.setTelephone("6625550144");
    Optional<Owner> ofResult = Optional.of(owner);
    when(ownerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/owners/{ownerId}", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(ownerController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("owner"))
        .andExpect(view().name("owners/ownerDetails"))
        .andExpect(forwardedUrl("owners/ownerDetails"));
  }
}

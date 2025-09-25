package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OwnerDiffblueTest {
  /**
   * Test {@link Owner#addPet(Pet)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Pet} (default constructor) Id is {@code null}.
   *   <li>Then {@link Owner} (default constructor) Pets size is one.
   * </ul>
   *
   * <p>Method under test: {@link Owner#addPet(Pet)}
   */
  @Test
  @DisplayName(
      "Test addPet(Pet); given 'null'; when Pet (default constructor) Id is 'null'; then Owner (default constructor) Pets size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Owner.addPet(Pet)"})
  void testAddPet_givenNull_whenPetIdIsNull_thenOwnerPetsSizeIsOne() {
    // Arrange
    Owner owner = new Owner();

    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(null);
    pet.setName("Bella");
    pet.setType(type);

    // Act
    owner.addPet(pet);

    // Assert
    List<Pet> pets = owner.getPets();
    assertEquals(1, pets.size());
    assertSame(pet, pets.get(0));
  }

  /**
   * Test {@link Owner#addPet(Pet)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Pet} (default constructor) Id is one.
   *   <li>Then {@link Owner} (default constructor) Pets Empty.
   * </ul>
   *
   * <p>Method under test: {@link Owner#addPet(Pet)}
   */
  @Test
  @DisplayName(
      "Test addPet(Pet); given one; when Pet (default constructor) Id is one; then Owner (default constructor) Pets Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Owner.addPet(Pet)"})
  void testAddPet_givenOne_whenPetIdIsOne_thenOwnerPetsEmpty() {
    // Arrange
    Owner owner = new Owner();

    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(1);
    pet.setName("Bella");
    pet.setType(type);

    // Act
    owner.addPet(pet);

    // Assert that nothing has changed
    assertTrue(owner.getPets().isEmpty());
  }

  /**
   * Test {@link Owner#getPet(Integer)} with {@code id}.
   *
   * <ul>
   *   <li>Given {@link Owner} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Owner#getPet(Integer)}
   */
  @Test
  @DisplayName("Test getPet(Integer) with 'id'; given Owner (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet Owner.getPet(Integer)"})
  void testGetPetWithId_givenOwner() {
    // Arrange, Act and Assert
    assertNull(new Owner().getPet(1));
  }

  /**
   * Test {@link Owner#getPet(Integer)} with {@code id}.
   *
   * <ul>
   *   <li>Given {@link PetType} (default constructor) Id is one.
   * </ul>
   *
   * <p>Method under test: {@link Owner#getPet(Integer)}
   */
  @Test
  @DisplayName("Test getPet(Integer) with 'id'; given PetType (default constructor) Id is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet Owner.getPet(Integer)"})
  void testGetPetWithId_givenPetTypeIdIsOne() {
    // Arrange
    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(null);
    pet.setName("Bella");
    pet.setType(type);

    Owner owner = new Owner();
    owner.addPet(pet);

    // Act and Assert
    assertNull(owner.getPet(1));
  }

  /**
   * Test {@link Owner#getPet(String, boolean)} with {@code name}, {@code ignoreNew}.
   *
   * <ul>
   *   <li>Given {@link Owner} (default constructor).
   *   <li>When {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Owner#getPet(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getPet(String, boolean) with 'name', 'ignoreNew'; given Owner (default constructor); when 'true'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet Owner.getPet(String, boolean)"})
  void testGetPetWithNameIgnoreNew_givenOwner_whenTrue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Owner().getPet("Bella", true));
  }

  /**
   * Test {@link Owner#getPet(String, boolean)} with {@code name}, {@code ignoreNew}.
   *
   * <ul>
   *   <li>Given {@link Pet} (default constructor) Name is {@code Bella}.
   *   <li>When {@code false}.
   *   <li>Then return {@link Pet} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Owner#getPet(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getPet(String, boolean) with 'name', 'ignoreNew'; given Pet (default constructor) Name is 'Bella'; when 'false'; then return Pet (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet Owner.getPet(String, boolean)"})
  void testGetPetWithNameIgnoreNew_givenPetNameIsBella_whenFalse_thenReturnPet() {
    // Arrange
    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(null);
    pet.setName("Bella");
    pet.setType(type);

    Owner owner = new Owner();
    owner.addPet(pet);

    // Act and Assert
    assertSame(pet, owner.getPet("Bella", false));
  }

  /**
   * Test {@link Owner#getPet(String, boolean)} with {@code name}, {@code ignoreNew}.
   *
   * <ul>
   *   <li>Given {@link Pet} (default constructor) Name is {@code Bella}.
   *   <li>When {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Owner#getPet(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getPet(String, boolean) with 'name', 'ignoreNew'; given Pet (default constructor) Name is 'Bella'; when 'true'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet Owner.getPet(String, boolean)"})
  void testGetPetWithNameIgnoreNew_givenPetNameIsBella_whenTrue_thenReturnNull() {
    // Arrange
    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(null);
    pet.setName("Bella");
    pet.setType(type);

    Owner owner = new Owner();
    owner.addPet(pet);

    // Act and Assert
    assertNull(owner.getPet("Bella", true));
  }

  /**
   * Test {@link Owner#getPet(String, boolean)} with {@code name}, {@code ignoreNew}.
   *
   * <ul>
   *   <li>Given {@link Pet} (default constructor) Name is {@code Name}.
   *   <li>When {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Owner#getPet(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getPet(String, boolean) with 'name', 'ignoreNew'; given Pet (default constructor) Name is 'Name'; when 'true'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet Owner.getPet(String, boolean)"})
  void testGetPetWithNameIgnoreNew_givenPetNameIsName_whenTrue_thenReturnNull() {
    // Arrange
    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(null);
    pet.setName("Name");
    pet.setType(type);

    Owner owner = new Owner();
    owner.addPet(pet);

    // Act and Assert
    assertNull(owner.getPet("Bella", true));
  }

  /**
   * Test {@link Owner#getPet(String)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link Owner} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Owner#getPet(String)}
   */
  @Test
  @DisplayName(
      "Test getPet(String) with 'name'; given Owner (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet Owner.getPet(String)"})
  void testGetPetWithName_givenOwner_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Owner().getPet("Bella"));
  }

  /**
   * Test {@link Owner#getPet(String)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link Pet} (default constructor) Name is {@code Bella}.
   *   <li>Then return {@link Pet} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Owner#getPet(String)}
   */
  @Test
  @DisplayName(
      "Test getPet(String) with 'name'; given Pet (default constructor) Name is 'Bella'; then return Pet (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet Owner.getPet(String)"})
  void testGetPetWithName_givenPetNameIsBella_thenReturnPet() {
    // Arrange
    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(null);
    pet.setName("Bella");
    pet.setType(type);

    Owner owner = new Owner();
    owner.addPet(pet);

    // Act and Assert
    assertSame(pet, owner.getPet("Bella"));
  }

  /**
   * Test {@link Owner#getPet(String)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link Pet} (default constructor) Name is {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Owner#getPet(String)}
   */
  @Test
  @DisplayName(
      "Test getPet(String) with 'name'; given Pet (default constructor) Name is 'Name'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Pet Owner.getPet(String)"})
  void testGetPetWithName_givenPetNameIsName_thenReturnNull() {
    // Arrange
    PetType type = new PetType();
    type.setId(1);
    type.setName("Dog");

    Pet pet = new Pet();
    pet.setBirthDate(LocalDate.of(1970, 1, 1));
    pet.setId(null);
    pet.setName("Name");
    pet.setType(type);

    Owner owner = new Owner();
    owner.addPet(pet);

    // Act and Assert
    assertNull(owner.getPet("Bella"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Owner}
   *   <li>{@link Owner#setAddress(String)}
   *   <li>{@link Owner#setCity(String)}
   *   <li>{@link Owner#setTelephone(String)}
   *   <li>{@link Owner#toString()}
   *   <li>{@link Owner#getAddress()}
   *   <li>{@link Owner#getCity()}
   *   <li>{@link Owner#getPets()}
   *   <li>{@link Owner#getTelephone()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void Owner.<init>()",
    "String Owner.getAddress()",
    "String Owner.getCity()",
    "List Owner.getPets()",
    "String Owner.getTelephone()",
    "void Owner.setAddress(String)",
    "void Owner.setCity(String)",
    "void Owner.setTelephone(String)",
    "String Owner.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Owner actualOwner = new Owner();
    actualOwner.setAddress("42 Main St");
    actualOwner.setCity("Oxford");
    actualOwner.setTelephone("6625550144");
    actualOwner.toString();
    String actualAddress = actualOwner.getAddress();
    String actualCity = actualOwner.getCity();
    List<Pet> actualPets = actualOwner.getPets();

    // Assert
    assertEquals("42 Main St", actualAddress);
    assertEquals("6625550144", actualOwner.getTelephone());
    assertEquals("Oxford", actualCity);
    assertNull(actualOwner.getId());
    assertNull(actualOwner.getFirstName());
    assertNull(actualOwner.getLastName());
    assertTrue(actualPets.isEmpty());
  }
}

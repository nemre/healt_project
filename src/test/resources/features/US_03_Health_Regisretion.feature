Feature: US_03 Registration Password

  @tc1
  Scenario: TC_01 4 haneli Password testi

    Given Kullanıcı "<medunnaUrl>" sayfasına gider
    Then Registration butonuna tıklar vekayıt sayfasına gider
    Then tek haneli şifre  girer ve yeterli uzunlukta olmadığını görür
    And iki haneli şifre  girer ve yeterli uzunlukta olmadığını görür
    And üç haneli şifre  girer ve yeterli uzunlukta olmadığını görür
    Then 4 haneli şifre  girer ve kabul edildiğini görür


  @tc2
  Scenario: TC_02 Güçlü password testi
    Given Kullanıcı "<medunnaUrl>" sayfasına gider
    Then Registration butonuna tıklar vekayıt sayfasına gider
    Then İçerisinde bir küçük harf olan enaz yedi haneli password girer
    And Password strength seviyesinin değiştiğini görür

  @tc3
  Scenario: TC_03 Güçlü password testi
    Given Kullanıcı "<medunnaUrl>" sayfasına gider
    Then Registration butonuna tıklar vekayıt sayfasına gider
    Then İçerisinde bir küçük bir büyük harf olan 7 haneli password girer
    And Password strength seviyesinin değiştiğini görür


  @tc4
  Scenario: TC_04 Güçlü password testi
    Given Kullanıcı "<medunnaUrl>" sayfasına gider
    Then Registration butonuna tıklar vekayıt sayfasına gider
    Then İçerisinde bir büyük bir küçük ve rakam harf olan enaz yedi haneli password girer
    And Password strength seviyesinin değiştiğini görür

  @tc5
  Scenario: TC_05 Güçlü password testi
    Given Kullanıcı "<medunnaUrl>" sayfasına gider
    Then Registration butonuna tıklar vekayıt sayfasına gider
    Then İçerisinde bir büyük bir küçük rakam harf ve ozel karakter olan enaz yedi haneli password girer
    And Password strength seviyesinin değiştiğini görür

  @tc6
  Scenario: TC_06 Space tuşu ile Güçlü Password oluşturulabilir
    Given Kullanıcı "<medunnaUrl>" sayfasına gider
    Then Registration butonuna tıklar vekayıt sayfasına gider
    Then Password olarak yedi kez  space tuşuna basar
    And Password strength seviyesinin değiştiğini görür
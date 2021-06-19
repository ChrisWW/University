package main.scala

object cwiczenie2 {
  def main(args: Array[String]): Unit = {

    // zad 1
    println("Zadanie 1")
    println(zad1("Wtorek"))
    println(zad1("Niedziela"))
    println(zad1("NieDzienTygodnia"))

    //zad 2
    println()
    println("Zadanie 2")
    val konto = new KontoBankowe()
    assert(konto.stanKontaBankowego == 0)
    konto.wplata(150)
    assert(konto.stanKontaBankowego == 150)
    println(konto.stanKontaBankowego)


    val pieniadze = konto.wyplata(75)
    assert(pieniadze == 75)
    assert(konto.stanKontaBankowego == 75)
    println(konto.stanKontaBankowego)

    println()
  }


  // zad 3

  println("Zadanie 3")
  val osoba1 = Osoba("Zbyszek", "Kowalski")
  val osoba2 = Osoba("James", "Bond")
  val osoba3 = Osoba("Michal", "Kotarski")
  val osoba4 = Osoba("Kornel", "Zalaski")

  dzienDoberek(osoba1)
  dzienDoberek(osoba2)
  dzienDoberek(osoba3)
  dzienDoberek(osoba4)

  println()

  // zad 4
  println("Zadanie 4")
  def funkcjaZad4(funkcja: Int => Int, c: Int): Int = funkcja(funkcja(funkcja(c)))
  println(funkcjaZad4(y => y+y, 9));

  println()

  // zad 5
  println("Zadanie 5")

  val n = new Osoba("Test", "Test") with Nauczyciel
  val p = new Osoba("Test", "Test") with Pracownik
  val s = new Osoba("Test", "Test") with Student

  val sn = new Osoba("Test", "Test") with Student with Nauczyciel
  val sp = new Osoba("Test", "Test") with Student with Pracownik
  val ps = new Osoba("Test", "Test") with Pracownik with Student

  println("Nauczyciel: " + n.podatek + "%")
  println("Pracownik: " + p.podatek + "%")
  println("Student: " + s.podatek + "%")

  println("Student nauczyciel: " + sn.podatek + "%")
  println("Student pracownik: " + sp.podatek + "%")
  println("Pracownik student: " + ps.podatek + "%")

  println()

  def zad1(string: String): String = {

    val workDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek")
    val weekendDays = List("Sobota", "Niedziela")

    string match {
      case a if (workDays.contains(a)) => "Work"
      case b if (weekendDays.contains(b)) => "Weekend"
      case _ => "Taki dzien nie istnieje"
    }
  }


  // zad 2
  class KontoBankowe(private var stanKonta: BigDecimal) {
    def this() = this(0)


    def wplata(kwota: BigDecimal): Unit = {
      this.stanKonta += kwota.max(0)
    }

    def wyplata(kwota: BigDecimal): BigDecimal = {
      var wyplata = kwota.min(this.stanKonta)
      this.stanKonta -= wyplata
      wyplata

    }

    def stanKontaBankowego: BigDecimal = stanKonta
  }


  // zad 3 oraz 5

  case class Osoba(val imie: String, val nazwisko: String) {
    val podatek = 0
  }

  trait Student extends Osoba {
    override val podatek: Int = 0
  }

  trait Pracownik extends Osoba {
    override val podatek: Int = 20
    var pensja: Double = 0
  }

  trait Nauczyciel extends Pracownik {
    override val podatek: Int = 10
  }

  def dzienDoberek(osoba: Osoba) = {
    val pozdrowienia = osoba match {
      case Osoba("Zbyszek", "Kowalski") => "Witaj, Zbyszek jestem"
      case Osoba("James", "Bond") => "Jestem James... James Bond"
      case Osoba("Michal", "Kotarski") => "Czesc Michal z tej strony"
      case _ => "Dzien doberek!"
    }
    println(pozdrowienia)
    pozdrowienia

  }
}

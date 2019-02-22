package dk.cphbusiness.vetapplication

open class Pet(val id: Int, var name: String) {
    var alive = true
    open val description: String
        get() = "A pet called $name probably a rabbit"
    open fun kill() { alive = false }
    }

class Cat(id: Int, name: String, var livesLeft: Int = 9) : Pet(id, name) {
    override val description: String
        get() = "This is the cat $name, who still has $livesLeft lives"

    override fun kill() {
        if (livesLeft > 0) livesLeft--
        if (livesLeft == 0) alive = false
        }
    }

class Dog(id: Int, name: String, val barkPitch: String) : Pet(id, name) {
    override val description: String
        get() = "The dog named $name barks at $barkPitch"
    }

val pets = mutableListOf(
    Cat(1, "Felix"),
    Dog(2, "Rufus", "C4"),
    Dog(3, "Kvast V", "D3"),
    Pet(4, "Killer"),
    Cat(5, "Pusser", 5),
    Cat(6, "Pelle Haleløs")
    )

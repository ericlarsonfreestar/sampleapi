package models

import play.api.libs.functional.syntax._
import play.api.libs.json.{JsPath, Reads}


//case class PokemonTypes(slot: Int, "type":PokemonTypeName)
case class PokeTypes(types: PokeType)
case class PokeType(`type`: PokeName)
case class PokeName(name: String)


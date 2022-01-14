package controllers

import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import play.api.libs.json._
import javax.inject._
import models._

import play.api.mvc._
import play.api.libs.ws._
import play.api.http.HttpEntity
import scala.concurrent.{Future, Await}
import scala.util.{Failure, Success}
import scala.concurrent.duration._
import scala.io.Source.fromURL


import scala.concurrent.ExecutionContext

@Singleton
class PokemonController @Inject() (ws:WSClient, val controllerComponents: ControllerComponents) extends BaseController {
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
  
  def getAll(): Action[AnyContent] = Action {
    NoContent
  }

  def getPokemon(pokemonName: String): Action[AnyContent] = Action {
    try {
      val pokeUrl = "https://pokeapi.co/api/v2/pokemon/" + pokemonName
    
      val futureResult = ws.url(pokeUrl).get().map { response =>
        response.json           
      }
      val response = Await.result(futureResult, 10.second)
      // validate the repsonse
   
      val types:JsValue = response("types")
      Ok(types)
    }
    catch {
      case e: Exception => NoContent
    }
    
    
  }
    

}



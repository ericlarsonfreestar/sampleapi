# sampleapi
This is a sampleapi project.  This project is an API to check a given pokemon's type.  The result will be in JSON format.  This poject uses scala and sbt to run.

### Installation:
- Clone the repo.
- Navigate inside the folder with this repo and run the command `sbt run` in the terminal
- Now that the API is running locally, you can query it by calling
`$curl localhost:9000/pokemon/{pokemonName}`, where pokemonName is any valid pokemon from the games.

Ex: `curl -v localhost:9000/pokemon/charizard`

Returns: 
    `[
        {
            "slot": 1,
            "type": {
                "name": "fire",
                "url": "https://pokeapi.co/api/v2/type/10/"
            }
        },
        {
            "slot": 2,
            "type": {
                "name": "fighting",
                "url": "https://pokeapi.co/api/v2/type/2/"
            }
        }
    ]`

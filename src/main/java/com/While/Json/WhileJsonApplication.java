package com.While.Json;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WhileJsonApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(WhileJsonApplication.class, args);
		
		// criando JSONObject
        JSONObject my_obj = new JSONObject();
		
        //colocando dados em JSONObject
		my_obj.put("Nome", "Leandro");
		my_obj.put("Sobrenome", "Barros");
		my_obj.put("idade", 43);

		//lendo os dados de JSONOBject
		System.out.println(my_obj);
		
		
		//para dados de endereço, primeiro crie LinkedHashMap
		Map m = new LinkedHashMap(4);
		m.put("streetAdress ", " estrada do Engenho Novo");
		m.put("city ", " Rio de Janeiro");
		m.put("state ", " Rio de Janeiro");
		m.put("postalCode ", 21730);
		
		//lendo os dados de JSONArray
		System.out.println(m);
		
		//colocando endereço em JSONObject
		my_obj.put("address", m);
		
		//para números de telefone, primeiro crie JSONArray
		JSONArray my_arr = new JSONArray();
		
		m = new LinkedHashMap(2);
		m.put("type", "home");
		m.put("number", "21 98870-9057");
		
		//adicionando mapa a lista
		my_arr.add(m);
		
		m = new LinkedHashMap(2);
		m.put("type", "fax");
		m.put("number", "21 2402-9057");
		
		//adicionando mapa a lista
		my_arr.add(m);
		
		
		//colocando phoneNumbers para JSONObject
		my_obj.put("phoneNumbers", my_arr);
		
		//escrevendo JSON no arquivo: "./src/main/java/cadastro.json"
		PrintWriter P = new PrintWriter("./src/main/java/cadastro.json");
		P.write(my_obj.toJSONString());
		
		P.flush();
		P.close();
	}
}

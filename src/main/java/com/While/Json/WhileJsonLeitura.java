package com.While.Json;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class WhileJsonLeitura {

	public static void main(String[] args) throws Exception {

		//analisando o arquivo "./src/main/java/cadastro.json"
		Object obj = new JSONParser().parse(new FileReader("./src/main/java/cadastro.json"));

		//typecasting obj para JSONObject
		JSONObject my_obj = (JSONObject) obj;

		//obtendo firstname e lastname
		String firstName = (String) my_obj.get("Nome");
		String lastName = (String) my_obj.get("Sobrenome");

		//lendo nome e sobrenome
		System.out.println(firstName);
		System.out.println(lastName);

		//recebendo e lendo a idade
		long age = (long)my_obj.get("idade");
		System.out.println(age);

		//recebendo endereço
		Map address = ((Map) my_obj.get("address"));

		//iterando mapa de endereços
		Iterator<Map.Entry> itr1 = address.entrySet().iterator();
		while (itr1.hasNext()) {
			Map.Entry pair = itr1.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());
		}

		//obtendo números de telefone
		JSONArray my_arr = (JSONArray) my_obj.get("phoneNumbers");

		//iterando phonenumbers
		Iterator itr2 = my_arr.iterator();

		while (itr2.hasNext()) {
			itr1 = ((Map) itr2.next()).entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();
				System.out.println(pair.getKey() + " : " + pair.getValue());

			}

		}

	}

}

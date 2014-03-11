/*
 * Copyright 2014 Alejandro Martin Cruz
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.upc.eetac.dsa.amartin.ejercicio7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import edu.upc.eetac.dsa.amartin.ejercicio7.Dato;


class Dato implements Serializable {


	private static final long serialVersionUID = 1L;
	
	int Numero;
	String Cadena;
	char Letra;
	
	public Dato (int num, String cad,char let) {
		Numero = num;
		Cadena = cad;
		Letra = let;
	}
	public String toString () {
		return Numero + " " + Cadena + " " + Letra;
	}
}
	
	
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Dato k = new Dato(6,"Pepito",'P');
        
        FileOutputStream F;
		try {
			F = new FileOutputStream ("c:\\fichero\\Datos.txt");
			ObjectOutputStream obj = new ObjectOutputStream (F);
	        obj.writeObject(k);
	        obj.close();
	        
	        FileInputStream G = new FileInputStream ("c:\\fichero\\Datos.txt");
	        ObjectInputStream objI = new ObjectInputStream (G);
	        Dato ahora = (Dato) objI.readObject();
	        objI.close();
	        System.out.println(ahora);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}

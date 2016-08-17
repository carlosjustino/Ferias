package br.com.carlosjustino.ferias;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Seconds;

public class Ferias {
	private int dias;
	private int horas;
	private int min;
	private int seg;

	private int dia;
	private int mes;
	private int ano;
	private String pessoa;
	private Date hoje;
	public Ferias() {
		dias = 0;
		horas = 0;
		min = 0;
		seg = 0;
	}
	public Ferias(Date h, int dia, int mes, int ano, String nome) {
		this();
		this.hoje = h;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.pessoa = nome;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSeg() {
		return seg;
	}

	public void setSeg(int seg) {
		this.seg = seg;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	public void calculo() {
		dias = 0;
		horas= 0;
		min= 0;
		seg= 0;
		DateTime ini, fim;
		ini = new DateTime(hoje);
				
		fim = new DateTime(ano, mes, dia, 18, 00, 0);
		seg = Seconds.secondsBetween(ini, fim).getSeconds();
		min = seg / 60;
		seg = seg - (min * 60);
		horas = min / 60;
		min = min - (horas * 60);
		dias = horas / 24;
		horas = horas - (dias * 24);
	}

	public String getMsg() {
		calculo();
		return "Faltam exatamente [" + dias + "] dias, [" + horas + "] horas, [" + min + "] minutos [" + seg
				+ "] segundos para as F�RIAS do "+pessoa+"...";
	}

	public static void main(String[] args) {
		Ferias justino;
		Date hoje = new Date();
		justino = new Ferias(hoje,19,8,2016,"Justino");
		System.out.println(justino.getMsg());
	}
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import model.Categorie;
import model.Chambre;
import model.Client;
import model.Employe;
import model.Passage;
import model.Reservation;
import model.Service;

/**
 *
 * @author mr-ali
 */
public class Traitement {
	private static Session session = HibernateUtil.getSessionFactory().openSession();

	//----Start Traitement chambre----------
	public void addChambre(Chambre chambre) {
		session.beginTransaction();
		session.save(chambre);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Add with successful");
	}

	public void editChambre(Chambre chambre) {
		session.beginTransaction();
		session.merge(chambre);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Updated with successful");
	}

	public void deleteChambre(Chambre chambre) {
		session.beginTransaction();
		session.delete(chambre);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Deleted with successful");

	}

	public ArrayList<Chambre> getAllChambre() {
		return (ArrayList<Chambre>) session.createCriteria(Chambre.class).list();
	}
	//----End Traitement chambre----------
	
	//----Start Traitement Categorie----------
	public ArrayList<Categorie> getAllCategories() {
		return (ArrayList<Categorie>) session.createCriteria(Categorie.class).list();

	}
	
	public void addCategorie(Categorie categorie) {
		session.beginTransaction();
		session.save(categorie);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Add with successful");

	}
	
	public void EditCategorie(Categorie categorie) {
		session.beginTransaction();
		session.merge(categorie);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Updated with successful");

	}
	
	public void DeleteCategorie(Categorie categorie) {
		session.beginTransaction();
		session.delete(categorie);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Delete with successful");

	}
	
	
	//----End Traitement Categorie----------

	public ArrayList<Service> getAllServices() {
		ArrayList<Service> liste = new ArrayList<>();
		liste.add(new Service(2, "222", 202));
		return liste;
	}
	//----Start Traitement Client----------

	public ArrayList<Client> getAllClients() {
		return (ArrayList<Client>) session.createCriteria(Client.class).list();
	}
	public void AddClient(Client client) {
		session.beginTransaction();
		session.save(client);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Add with successful");

	}
	public void EditClient(Client client) {
		session.beginTransaction();
		session.merge(client);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Updated with successful");

	}
	
	public void DeleteClient(Client client) {
		session.beginTransaction();
		session.delete(client);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Deleted with successful");

	}
	//----End Traitement Client----------

	//----Start Traitement Employe----------
	public ArrayList<Employe> gettAllEmployes() {
		return (ArrayList<Employe>) session.createCriteria(Employe.class).list();
	}
	
	public void AddEmplye(Employe employe) {
		session.beginTransaction();
		session.save(employe);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Add with successful");

	}
	
	public void EditEmplye(Employe employe) {
		session.beginTransaction();
		session.merge(employe);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Updated with successful");

	}
	
	public void DeleteEmplye(Employe employe) {
		session.beginTransaction();
		session.delete(employe);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Deleted with successful");

	}
	//----End Traitement Employe----------
	public void Reserver(Passage passage,Reservation reservation) {
		session.beginTransaction();
		session.save(passage);
		session.save(reservation);
		session.getTransaction().commit();
		JOptionPane.showMessageDialog(null, "Reserve with successful");
	}
}

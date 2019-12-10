package model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import entities.Departamento;
import entities.Vendedor;
import model.DAO.VendedorDAO;

public class VendedorDaoJDBC implements VendedorDAO {

	private Connection conn;

	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Vendedor obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Vendedor obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vendedor findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?";
			st = conn.prepareStatement(sql);

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departamento dep = instanciarDepartamento(rs);

				Vendedor vend = instanciarVendedor(rs, dep);

				return vend;
			}
			return null;

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

	private Vendedor instanciarVendedor(ResultSet rs, Departamento dep) throws SQLException {

		Vendedor vend = new Vendedor();
		vend.setId(rs.getInt("Id"));
		vend.setNome(rs.getString("Name"));
		vend.setEmail(rs.getString("Email"));
		vend.setBaseSalary(rs.getDouble("BaseSalary"));
		vend.setBirthDate(rs.getDate("BirthDate"));
		vend.setDepartamento(dep);
		return vend;

	}

	private Departamento instanciarDepartamento(ResultSet rs) throws SQLException {

		Departamento dep = new Departamento();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setNome(rs.getString("DepName"));
		return dep;

	}

	@Override
	public List<Vendedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vendedor> findByDepartamento(Departamento dep) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE DepartmentId = ? " + "ORDER BY Name");

			st.setInt(1, dep.getId());

			rs = st.executeQuery();
			
			List<Vendedor> vendedores = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (rs.next()) {
				
				Departamento departamento = map.get(rs.getInt("DepartmentId"));
				
				if(departamento == null) {
					departamento = instanciarDepartamento(rs);
					map.put(rs.getInt("DepartmentId"), departamento);
				}
						
				Vendedor vend = instanciarVendedor(rs, departamento);
				vendedores.add(vend);
			}
			return vendedores;

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

}

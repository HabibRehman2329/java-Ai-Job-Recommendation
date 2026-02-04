package com.jobai.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jobai.model.AIResult;
import com.jobai.util.DatabaseConnection;

public class AIResultDAO {

	// SAVE AI RESULT
	public boolean saveAIResult(AIResult result) {

		String sql = "INSERT INTO ai_results (user_id, input_text, result_text, type) VALUES (?, ?, ?, ?)";

		try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, result.getUserId());
			ps.setString(2, result.getInputText());
			ps.setString(3, result.getResultText());
			ps.setString(4, result.getType());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// FETCH HISTORY
	public List<AIResult> getResultsByUserId(int userId) {

		List<AIResult> list = new ArrayList<>();

		String sql = "SELECT * FROM ai_results WHERE user_id = ? ORDER BY created_at DESC";

		try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				AIResult r = new AIResult();
				r.setId(rs.getInt("id"));
				r.setUserId(rs.getInt("user_id"));
				r.setInputText(rs.getString("input_text"));
				r.setResultText(rs.getString("result_text"));
				r.setType(rs.getString("type"));
				r.setCreatedAt(rs.getTimestamp("created_at"));

				list.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

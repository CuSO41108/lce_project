package com.lce.dao;

import com.lce.model.KnowledgeBase;
import com.lce.util.DBUtil;
import java.sql.*;

public class KnowledgeBaseDao {
    // 创建知识库
    public boolean createKnowledgeBase(KnowledgeBase knowledgeBase) {
        String sql = "INSERT INTO knowledge_base (name, introduction, creator_id, is_public) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, knowledgeBase.getName());
            stmt.setString(2, knowledgeBase.getIntroduction());
            stmt.setInt(3, knowledgeBase.getCreator_id());
            stmt.setBoolean(4, knowledgeBase.getIs_public());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 根据ID查询知识库
    public KnowledgeBase findById(int id) {
        String sql = "SELECT * FROM knowledge_base WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                KnowledgeBase kb = new KnowledgeBase();
                kb.setId(rs.getInt("id"));
                kb.setName(rs.getString("name"));
                kb.setIntroduction(rs.getString("introduction"));
                kb.setCreator_id(rs.getInt("creator_id"));
                kb.setIs_public(rs.getBoolean("is_public"));
                return kb;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

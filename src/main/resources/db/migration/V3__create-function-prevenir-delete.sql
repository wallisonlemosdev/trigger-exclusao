CREATE OR REPLACE FUNCTION prevenir_delete_post_com_comentarios()
RETURNS TRIGGER AS $$
BEGIN
    IF (SELECT COUNT(*) FROM comentarios WHERE post_id = OLD.id) > 0 THEN
        RAISE EXCEPTION 'Não é possível excluir um Post que tem comentários associados';
END IF;
RETURN OLD;
END;
$$ LANGUAGE plpgsql;
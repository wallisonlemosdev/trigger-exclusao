CREATE OR REPLACE FUNCTION prevenir_logic_delete_post_com_comentarios()
RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'UPDATE' AND NEW.deleted = true AND OLD.deleted = false) THEN
        IF (SELECT COUNT(*) FROM comentarios WHERE post_id = OLD.id) > 0 THEN
            RAISE EXCEPTION 'Não é possível excluir um Post que tem comentários associados';
END IF;
END IF;
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

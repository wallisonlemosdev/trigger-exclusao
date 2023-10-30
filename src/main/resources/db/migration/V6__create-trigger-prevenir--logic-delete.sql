CREATE TRIGGER prevenir_logic_delete_post_trigger
    BEFORE UPDATE ON posts
    FOR EACH ROW
    EXECUTE FUNCTION prevenir_logic_delete_post_com_comentarios();
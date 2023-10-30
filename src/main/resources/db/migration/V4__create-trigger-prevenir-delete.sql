CREATE TRIGGER prevenir_delete_post_trigger
    BEFORE DELETE ON posts
    FOR EACH ROW
    EXECUTE FUNCTION prevenir_delete_post_com_comentarios();
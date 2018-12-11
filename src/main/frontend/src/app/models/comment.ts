import { User } from "./user";
import { Article } from "./article";

export class Comment {
    id:number;
    article:Article;
    commentaire:string;
    user:User;
}
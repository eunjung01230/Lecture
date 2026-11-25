import { user } from "./uers";

export default function EmailCard() {
    return <h3 style={{color : 'blue'}}>{user.email}</h3>
}
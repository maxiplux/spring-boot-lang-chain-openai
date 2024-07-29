export class User {
  id?: number;
  username?: string;
  password?: string;
  email?: string;
  roles?: string[] = [];
}
export interface Token {
  access_token: string;
  token_type: string;

}

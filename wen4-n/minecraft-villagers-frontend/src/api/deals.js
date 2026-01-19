import { api } from "./api";

export async function getAllDeals() {
  return await api.get("/deals");
}

export async function getDealById(id) {
  return await api.get(`/deals/${id}`);
}

export async function createDeal(deal) {
  return await api.post("/deals", deal);
}

export async function updateDeal(deal) {
  return await api.put("/deals", deal);
}

export async function deleteDealById(id) {
  await api.delete(`/deals/${id}`);
}

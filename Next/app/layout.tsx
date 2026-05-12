import type { Metadata } from "next";
import "./globals.css";

export const metadata: Metadata = {
  title: "ProjetoLogin",
  description: "Criando um projeto que une back-end com front-end",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html
      lang="en"
    >
      <body className="min-h-full flex flex-col">{children}</body>
    </html>
  );
}
